package com.htmlism.idioma.spanish

import cats.data.*
import cats.effect.*
import cats.effect.std.Console
import cats.syntax.all.*

import com.htmlism.idioma.dataloader.DataLoader

object PrintConjugation extends PrintConjugation[IO] with IOApp.Simple

class PrintConjugation[F[_]: Sync](using out: Console[F]):
  val forms =
    NonEmptyList.of(
      VerbalFormKey.Infinitive,
      VerbalFormKey.PastParticiple,
      VerbalFormKey.Gerund
    ) ::: VerbalFormKey.matrix.map((VerbalFormKey.PresentMood.apply _).tupled)

  def run: F[Unit] =
    for
      xs <- DataLoader.getYaml[F, List[Map[String, String]]]("verbs.yaml")

      _ <- xs
        .traverse { xs =>
          for
            verb <- ParsedVerb
              .unapply(xs("infinitive"))
              .liftTo[F](new NoSuchElementException("could not find infinitive"))

            _ <- out.println(verb)

            _ <- out.println("https://www.linguasorb.com/spanish/verbs/conjugation/" + verb.infinitive)

            _ <- forms
              .traverse(f => out.println(VerbConjugator.getForm(verb, xs, f)))

            _ <- out.println("")
          yield ()
        }
    yield ()
