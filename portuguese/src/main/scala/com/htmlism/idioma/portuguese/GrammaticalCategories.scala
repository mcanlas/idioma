package com.htmlism.idioma.portuguese

object GrammaticalCategories {
  val Present     = Tense("present")
  val Perfect     = Tense("perfect")
  val Imperfect   = Tense("imperfect")
  val Pluperfect  = Tense("pluperfect")
  val Future      = Tense("future")
  val Conditional = Tense("conditional")

  val PresentSubjunctive   = Tense("presentSubjunctive")
  val ImperfectSubjunctive = Tense("imperfectSubjunctive")
  val FutureSubjunctive    = Tense("futureSubjunctive")

  val FirstPerson  = Person("first")
  val SecondPerson = Person("second")
  val ThirdPerson  = Person("third")

  val Singular  = Number("singular")
  val Plural    = Number("plural")
}

case class Tense(tense: String)

case class Person(person: String)

case class Number(number: String)
