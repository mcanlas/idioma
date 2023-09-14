package com.htmlism.idioma

import scala.io.Source

object PrepositionCards extends TranslationCardIterator:
  def partsIterator: Iterator[(String, String, String)] =
    val prepositions = Source
      .fromResource("prepositions.tsv")
      .getLines()
      .toList

    prepositions
      .tail
      .iterator
      .map { s =>
        val Array(english, korean) = s.split("\t")

        (english, english, korean)
      }
