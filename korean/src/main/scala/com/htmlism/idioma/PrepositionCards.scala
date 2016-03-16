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

        Seq(
          AnkiCardValue(
            "eng2kor-" + english,
            s"""<div id="preface">$english</div>""",
            s"""<div id="heroic-answer">$korean</div>"""),
          AnkiCardValue(
            "kor2eng-" + english,
            s"""<div id="heroic-answer">$korean</div>""",
            s"""<div id="preface">$english</div>"""))
      }
  }
}
