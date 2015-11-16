package com.htmlism.idioma

import scala.io.Source

import com.htmlism.hangul.Hangul

object VowelCards {
  val iterator: Iterator[AnkiCard] = {
    val vowels = Source.fromFile("data/korean/vowels.csv").getLines()

    // skip the header
    vowels.next()

    vowels
      .map { s =>
        val Array(n, pronunciation) = s.split(",")

        val character = (Hangul.medialOriginCodePoint + n.toInt - 1).toChar

        AnkiCardValue(
          "name-vowel-" + n,
          s"""<div id="preface">How do you pronounce this vowel?</div>""" +
            s"""<div id="heroic-character">$character</div>""",
          s"""<div id="heroic-answer">$pronunciation</div>""")
      }
  }
}
