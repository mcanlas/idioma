package com.htmlism.idioma

import scala.io.Source

object PrepositionCards {
  val iterator: Iterator[AnkiCard] = {
    val prepositions = Source.fromFile("data/korean/prepositions.tsv").getLines()

    // skip the header
    prepositions.next()

    prepositions
      .flatMap { s =>
        val Array(english, korean) = s.split("\t")

        GenerateAnkiCards.translationCards(english, english, korean)
      }
  }
}
