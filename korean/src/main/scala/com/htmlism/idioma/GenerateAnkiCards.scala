package com.htmlism.idioma

import scala.io.Source

object GenerateAnkiCards extends App {
  val consonants = Source.fromFile("data/korean/consonants.csv").getLines()

  consonants.foreach(println)
}

trait AnkiCard {
  def front: String

  def back: String
}

case class AnkiCardValue(front: String, back: String) extends AnkiCard
