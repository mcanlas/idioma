package com.htmlism.idioma

import org.json4s.JsonAST.{ JValue, JString, JObject }

object Verb {
  case object FirstConjugation
  case object SecondConjugation
  case object ThirdConjugation

  val rootPattern = "(.*)(aei)r".r

  def apply(jv: JValue): Verb = jv match {
    case JObject(fields) =>
      val map = fields.toMap

      val JString(infinitive) = map("infinitive")

      val conjugation = infinitive match {
        case rootPattern(root, vowel) => vowel match {
          case "a" => FirstConjugation
          case "e" => SecondConjugation
          case "i" => ThirdConjugation

        } //println(root)
        case _ => throw new IllegalArgumentException(s"could not find root for infinitive $infinitive")
      }

      Verb(
        infinitive,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
      )
    case _ => throw new IllegalArgumentException("verb constructor needs a jObject")
  }
}

case class Verb(
  infinitive:         String,
  present:            Tense,
  perfect:            Tense,
  imperfect:          Tense,
  pluperfect:         Tense,
  future:             Tense,
  conditional:        Tense,
  subjunctivePresent: Tense,
  subjectivePast:     Tense,
  subjectiveFuture:   Tense
)
