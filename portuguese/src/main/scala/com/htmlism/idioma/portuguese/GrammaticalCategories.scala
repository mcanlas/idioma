package com.htmlism.idioma.portuguese

object GrammaticalCategories {
  val Present     = Tense("present",     "PRES")
  val Perfect     = Tense("perfect",     "PERF")
  val Imperfect   = Tense("imperfect",   "IMP")
  val Pluperfect  = Tense("pluperfect",  "PLU")
  val Future      = Tense("future",      "FUT")
  val Conditional = Tense("conditional", "CND")

  val PresentSubjunctive   = Tense("presentSubjunctive",   "PRESSUB")
  val ImperfectSubjunctive = Tense("imperfectSubjunctive", "IMPSUB")
  val FutureSubjunctive    = Tense("futureSubjunctive",    "FUTSUB")

  val FirstPerson  = Person("first", "1")
  val SecondPerson = Person("second", "2")
  val ThirdPerson  = Person("third", "3")

  val Singular  = Number("singular", "S")
  val Plural    = Number("plural", "P")

  val Tenses  = List(Present, Perfect, Imperfect, Pluperfect, Future, Conditional, PresentSubjunctive, ImperfectSubjunctive, FutureSubjunctive)
  val Persons = List(FirstPerson, SecondPerson, ThirdPerson)
  val Numbers = List(Singular, Plural)
}

case class Tense(tense: String, code: String)

case class Person(person: String, code: String)

case class Number(number: String, code: String)
