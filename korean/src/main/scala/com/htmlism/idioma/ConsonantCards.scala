package com.htmlism.idioma

import scala.io.Source

import com.htmlism.hangul.Hangul

object ConsonantCards:
  val iterator: Iterator[AnkiCard] =
    val consonants = Source
      .fromResource("consonants.csv")
      .getLines()
      .toList

    consonants
      .tail
      .iterator
      .map { s =>
        val Array(n, name) = s.split(",")

        val character = (Hangul.initialOriginCodePoint + n.toInt - 1).toChar

        AnkiCardValue(
          "name-consonant-" + n,
          s"""<div id="preface">What is the name of this consonant?</div>""" +
            s"""<div id="heroic-character">$character</div>""",
          s"""<div id="heroic-answer">$name</div>"""
        )
      }
