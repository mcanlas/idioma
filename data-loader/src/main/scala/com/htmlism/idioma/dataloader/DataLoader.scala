package com.htmlism.idioma.dataloader

import cats.effect.*
import cats.syntax.all._
import io.circe.Decoder
import io.circe.parser.decode

import java.io.InputStream
import scala.io.Source

object DataLoader:
  def getJson[F[_], A : Decoder](is: => InputStream)(using F: Sync[F]): F[A] =
    Resource
      .fromAutoCloseable(F.delay(is))
      .use { is =>
        F.delay:
          Source
            .fromInputStream(is)
            .mkString
      }
      .map(decode[A])
      .flatMap(_.liftTo[F])

  def getJsonUnsafe[A: Decoder](is: => InputStream): A =
    getJson[IO, A](is)
      .unsafeRunSync()(using cats.effect.unsafe.implicits.global)
