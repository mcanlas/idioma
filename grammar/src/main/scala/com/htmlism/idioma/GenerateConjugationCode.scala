package com.htmlism.idioma

object GenerateConjugationCode extends App {
  val persons = List("first", "second", "third")
  val numbers = List("Singular", "Plural")
  val tenses = List("Present", "Perfect", "Imperfect", "Pluperfect", "Future", "Conditional", "PresentSubjunctive", "ImperfectSubjunctive", "FutureSubjunctive")

  for (tense <- tenses) {
    println(s"\n// $tense")

    val valueNames = for {
      number <- numbers
      person <- persons
    } yield s"${person}Person$number$tense"

    val maximumLength = valueNames.map { _.length }.max

    for (v <- valueNames) {
      printf(s"lazy val %-${maximumLength}s = root + ???\n", v)
    }
  }

  for (tense <- tenses) {
    println(s"""\nprintln("\\n$tense:")""")

    for {
      number <- numbers
      person <- persons
    } {
      println(s"""println(${person}Person$number$tense)""")
    }
  }
}
