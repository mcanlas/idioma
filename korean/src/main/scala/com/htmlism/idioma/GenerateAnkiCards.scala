package com.htmlism.idioma

import java.io.PrintWriter

import com.htmlism.hangul.Hangul

import scala.io.Source

object GenerateAnkiCards extends App {
  val out = new PrintWriter(args(0))

  val consonants = Source.fromFile("data/korean/consonants.csv").getLines()

  // skip the header
  consonants.next()

  consonants
    .map { s =>
      val Array(n, name) = s.split(",")

      val character = (Hangul.initialOriginCodePoint + n.toInt - 1).toChar

      AnkiCardValue(
        "name-consonant-" + n,
        s"""<div id="preface">What is the name of this consonant?</div>""" +
          s"""<div id="heroic-character">$character</div>""",
        s"""<div id="heroic-answer">$name</div>""")
    }
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
