package com.htmlism.idioma

import java.io.PrintWriter

object GenerateAnkiCards extends App {
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
