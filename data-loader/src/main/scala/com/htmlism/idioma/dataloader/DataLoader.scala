package com.htmlism.idioma.dataloader

import scala.io.Source

import cats.effect.*
import cats.syntax.all._
import io.circe._
import io.circe.parser.decode

object DataLoader:
  def getJson[F[_], A: Decoder](path: String)(using F: Sync[F]): F[A] =
    slurp(path)
      .map(decode[A](_))
      .flatMap(_.liftTo[F])

  def getYaml[F[_], A: Decoder](path: String)(using F: Sync[F]): F[A] =
    slurp(path)
      .map(io.circe.yaml.parser.parse)
      .map(_.flatMap(_.as[A]))
      .flatMap(_.liftTo[F])

  def getJsonUnsafe[A: Decoder](path: String): A =
    getJson[IO, A](path)
      .unsafeRunSync()(using cats.effect.unsafe.implicits.global)

  private def slurp[F[_]](path: String)(using F: Sync[F]): F[String] =
    F.delay:
      Source
        .fromResource(path)
        .getLines()
        .mkString("\n")
