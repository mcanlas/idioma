package com.htmlism.idioma.spanish

import cats.effect.*
import cats.effect.std.Console
import cats.syntax.all._

import com.htmlism.idioma.dataloader.DataLoader

object Conjugate extends Conjugate[IO] with IOApp.Simple

class Conjugate[F[_]: Sync: Console]:
  def run: F[Unit] =
    for {
      xs <- DataLoader.getYaml[F, List[Map[String, String]]]("verbs.yaml")

      _ <- xs
        .traverse(xs => Console[F].println(ParsedVerb.unapply(xs("infinitive"))))
    } yield ()
