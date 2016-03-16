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
