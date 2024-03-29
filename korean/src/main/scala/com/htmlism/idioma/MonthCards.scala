package com.htmlism.idioma

import scala.io.Source

object MonthCards extends TranslationCardIterator:
  def partsIterator: Iterator[(String, String, String)] =
    val months = Source
      .fromResource("months.tsv")
      .getLines()
      .toList

    months
      .tail
      .iterator
      .map { s =>
        val Array(english, korean) = s.split("\t")

        (english, english, korean)
      }
