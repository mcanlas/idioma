package com.htmlism.idioma.spanish

import cats.effect.*
import cats.effect.std.Console
import cats.syntax.all._

import com.htmlism.idioma.dataloader.DataLoader

object Conjugate extends Conjugate[IO] with IOApp.Simple

class Conjugate[F[_]: Sync: Console]:
  def run: F[Unit] =
    for {
      _ <- DataLoader.getJson[F, List[String]](getClass.getResourceAsStream("/verbs.yaml"))

      _ <- Console[F].println("sup")
    } yield ()
