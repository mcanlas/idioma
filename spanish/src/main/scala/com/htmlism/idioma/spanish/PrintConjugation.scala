package com.htmlism.idioma.spanish

import cats.data._
import cats.effect.*
import cats.effect.std.Console
import cats.syntax.all._

import com.htmlism.idioma.dataloader.DataLoader

object PrintConjugation extends PrintConjugation[IO] with IOApp.Simple

class PrintConjugation[F[_]: Sync: Console]:
  val forms =
    NonEmptyList.of(
      VerbalForm.Infinitive,
      VerbalForm.PastParticiple,
      VerbalForm.Gerund
    ) ::: VerbalForm.personAndNumber.map((VerbalForm.PresentMood.apply _).tupled)

  def run: F[Unit] =
    for {
      xs <- DataLoader.getYaml[F, List[Map[String, String]]]("verbs.yaml")

      _ <- xs
        .traverse { xs =>
          for {
            verb <- ParsedVerb
              .unapply(xs("infinitive"))
              .liftTo[F](new NoSuchElementException("could not find infinitive"))

            _ <- Console[F].println(verb)

            _ <- forms
              .traverse(f => Console[F].println(VerbConjugator.getForm(verb, xs, f)))
          } yield ()
        }
    } yield ()
