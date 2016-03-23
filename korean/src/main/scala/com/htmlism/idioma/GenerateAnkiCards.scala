package com.htmlism.idioma

import java.io.PrintWriter

object GenerateAnkiCards extends App {
  def translationCards(keyFragment: String, english: String, korean: String): Seq[AnkiCard] =
    Seq(
      AnkiCardValue(
        "eng2kor-" + keyFragment,
        s"""<div id="preface">How do you say "$english" in Korean?</div>""",
        s"""<div id="heroic-answer">$korean</div>"""),
      AnkiCardValue(
        "kor2eng-" + keyFragment,
        s"""<div id="heroic-answer">$korean</div>""",
        s"""<div id="preface">$english</div>"""))

  val out = new PrintWriter(args(0))

  (ConsonantCards.iterator ++
    VerbCards.iterator ++
    PrepositionCards.iterator ++
    MonthCards.iterator ++
    NounCards.iterator ++
    VowelCards.iterator)
    .map(_.serialize)
    .foreach(out.println)

  out.close()
}

trait AnkiCard {
  def id: String

  def front: String

  def back: String

  def serialize: String = id + "\t" + front + "\t" + back
}

case class AnkiCardValue(id: String, front: String, back: String) extends AnkiCard
