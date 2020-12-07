package com.htmlism.idioma

object GenerateAnkiCards extends AnkiCardGenerator {
  def cards =
    ConsonantCards.iterator ++
      VerbCards.iterator ++
      PrepositionCards.iterator ++
      MonthCards.iterator ++
      NounCards.iterator ++
      VowelCards.iterator
}

trait TranslationCardIterator extends Iterable[AnkiCard] {
  def partsIterator: Iterator[(String, String, String)]

  def iterator: Iterator[AnkiCard] =
    partsIterator
      .flatMap { case (keyFragment, english, korean) =>
        Seq(
          AnkiCardValue(
            "eng2kor-" + keyFragment,
            s"""<div id="preface">How do you say this in Korean?</div>""" +
              s"""<div id="heroic-prompt-english">[$english]</div>""",
            s"""<div id="heroic-answer">$korean</div>"""
          ),
          AnkiCardValue(
            "kor2eng-" + keyFragment,
            s"""<div id="preface">What does this mean?</div>""" +
              s"""<div id="heroic-prompt-korean">$korean</div>""",
            s"""<div id="preface">$english</div>"""
          )
        )
      }
}
