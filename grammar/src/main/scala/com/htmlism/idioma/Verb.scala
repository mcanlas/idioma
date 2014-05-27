package com.htmlism.idioma

case class Verb(
  infinitive:         InflectedForm,
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
