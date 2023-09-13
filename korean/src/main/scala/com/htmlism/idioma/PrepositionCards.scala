package com.htmlism.idioma

import scala.io.Source

object PrepositionCards extends TranslationCardIterator {
  def partsIterator: Iterator[(String, String, String)] = {
    val prepositions = Source
      .fromInputStream(getClass.getResourceAsStream("/prepositions.tsv"))
      .getLines()

    // skip the header
    prepositions.next(): Unit

    prepositions
      .map { s =>
        val Array(english, korean) = s.split("\t")

        (english, english, korean)
      }
  }
}
