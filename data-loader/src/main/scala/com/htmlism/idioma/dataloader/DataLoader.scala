package com.htmlism.idioma.dataloader

import java.io.InputStream

import scala.io.Source

import cats.effect.*
import cats.syntax.all._
import io.circe._
import io.circe.parser.decode

object DataLoader:
  def getJson[F[_], A: JsonDecoder](is: => InputStream)(using F: Sync[F]): F[A] =
    slurp(is)
      .map(decode[A](_)(using summon[JsonDecoder[A]].circeDecoder))
      .flatMap(_.liftTo[F])

  def getYaml[F[_], A: JsonDecoder](is: => InputStream)(using F: Sync[F]): F[A] =
    slurp(is)
      .map(io.circe.yaml.parser.parse)
      .map(_.flatMap(_.as[A](using summon[JsonDecoder[A]].circeDecoder)))
      .flatMap(_.liftTo[F])

  def getJsonUnsafe[A: JsonDecoder](is: => InputStream): A =
    getJson[IO, A](is)
      .unsafeRunSync()(using cats.effect.unsafe.implicits.global)

  private def slurp[F[_]](is: => InputStream)(using F: Sync[F]): F[String] =
    Resource
      .fromAutoCloseable(F.delay(is))
      .use { is =>
        F.delay:
          Source
            .fromInputStream(is)
            .mkString
      }
