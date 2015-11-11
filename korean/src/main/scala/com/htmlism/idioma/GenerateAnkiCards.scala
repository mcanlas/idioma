package com.htmlism.idioma

import java.io.PrintWriter

import scala.io.Source

object GenerateAnkiCards extends App {
  val out = new PrintWriter(args(0))

  // write header
  out.println("front\tback")

  val consonants = Source.fromFile("data/korean/consonants.csv").getLines()

  // skip the header
  consonants.next()

  consonants.foreach(out.println)

  out.close()
}

trait AnkiCard {
  def front: String

  def back: String
}

case class AnkiCardValue(front: String, back: String) extends AnkiCard
