package com.htmlism.idioma

import java.io.PrintWriter

import scala.io.Source

object GenerateAnkiCards extends App {
  val out = new PrintWriter(args(0))

  val consonants = Source.fromFile("data/korean/consonants.csv").getLines()

  // skip the header
  consonants.next()

  consonants
    .map { s =>
      val Array(n, name) = s.split(",")

      AnkiCardValue(s"What is the name of this consonant?<div>$n</div>", name)
    }
    .map(_.serialize)
    .foreach(out.println)

  out.close()
}

trait AnkiCard {
  def front: String

  def back: String

  def serialize: String = front + "\t" + back
}

case class AnkiCardValue(front: String, back: String) extends AnkiCard
