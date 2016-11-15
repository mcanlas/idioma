package com.htmlism.idioma

import scala.io.Source

object MonthCards extends TranslationCardIterator {
  def partsIterator: Iterator[(String, String, String)] = {
    val months = Source.fromInputStream(getClass.getResourceAsStream("/months.tsv")).getLines()

    // skip the header
    months.next()

    months
      .map { s =>
        val Array(english, korean) = s.split("\t")

        (english, english, korean)
      }
  }
}
