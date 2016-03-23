package com.htmlism.idioma

import scala.io.Source

object MonthCards {
  val iterator: Iterator[AnkiCard] = {
    val months = Source.fromFile("data/korean/months.tsv").getLines()

    // skip the header
    months.next()

    months
      .flatMap { s =>
        val Array(english, korean) = s.split("\t")

        GenerateAnkiCards.translationCards(english, english, korean)
      }
  }
}
