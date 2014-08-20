package com.htmlism.idioma.portuguese

object CategoriasGramaticais {
  val Present     = Tense("present",     "PRS")
  val Past        = Tense("perfect",     "PST")
  val Imperfect   = Tense("imperfect",   "IMP")
  val Pluperfect  = Tense("pluperfect",  "PLU")
  val Future      = Tense("future",      "FUT")
  val Conditional = Tense("conditional", "CND")

  val PresentSubjunctive   = Tense("presentSubjunctive",   "PRSSUB")
  val ImperfectSubjunctive = Tense("imperfectSubjunctive", "IMPSUB")
  val FutureSubjunctive    = Tense("futureSubjunctive",    "FUTSUB")

  val FirstPerson  = Person("first",  "1")
  val SecondPerson = Person("second", "2")
  val ThirdPerson  = Person("third",  "3")

  val Singular  = Number("singular", "S")
  val Plural    = Number("plural",   "P")

  val Masculine = Gender("masculine", "m")
  val Feminine  = Gender("feminine",  "f")
  val Either    = Gender("either",    "mf")

  val Definite   = Definiteness("definite",   "d")
  val Indefinite = Definiteness("indefinite", "i")

  val Tenses  = List(Present, Past, Imperfect, Pluperfect, Future, Conditional, PresentSubjunctive, ImperfectSubjunctive, FutureSubjunctive)
  val Persons = List(FirstPerson, SecondPerson, ThirdPerson)
  val Numbers = List(Singular, Plural)
  val Genders = List(Masculine, Feminine, Either)
}

case class Tense(tempo: String, código: String)

case class Person(person: String, código: String)

case class Number(number: String, código: String)

case class Gender(gender: String, código: String)

case class Definiteness(definiteness: String, código: String)
