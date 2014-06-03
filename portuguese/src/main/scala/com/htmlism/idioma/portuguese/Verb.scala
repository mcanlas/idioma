package com.htmlism.idioma.portuguese

import org.json4s.JsonAST.{ JValue, JString, JObject }

object Verb {
  def apply(jv: JValue): Verb = jv match {
    case JObject(fields) =>
      val map = fields.toMap

      val JString(infinitive) = map("infinitive")

      val conjugation = Conjugation(infinitive)
      println(conjugation)

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
  present:            InflectedTense,
  perfect:            InflectedTense,
  imperfect:          InflectedTense,
  pluperfect:         InflectedTense,
  future:             InflectedTense,
  conditional:        InflectedTense,
  subjunctivePresent: InflectedTense,
  subjectivePast:     InflectedTense,
  subjectiveFuture:   InflectedTense
)
