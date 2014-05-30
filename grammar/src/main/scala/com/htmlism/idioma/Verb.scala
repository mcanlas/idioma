package com.htmlism.idioma

import org.json4s.JsonAST.{ JString, JObject}

object Verb {
  def apply(json: JObject): Verb = {
    val JObject(fields) = json

    val map = fields.toMap

    val JString(infinitive) = map("infinitive")

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
