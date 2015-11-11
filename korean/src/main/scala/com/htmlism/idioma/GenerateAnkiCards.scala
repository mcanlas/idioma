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

      AnkiCardValue(
        s"""<div id="preface">What is the name of this consonant?</div>""" +
          s"""<div id="heroic-character">$n</div>""",
        s"""<div id="heroic-answer">$name</div>""")
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
