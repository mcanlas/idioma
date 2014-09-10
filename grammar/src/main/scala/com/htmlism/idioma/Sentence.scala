package com.htmlism.idioma

trait Sentence

case class Statement(words: Seq[String]) extends Sentence {
  lazy val nonEmptyWords = words.filter { _.nonEmpty }

  def render = (nonEmptyWords.head.capitalize +: nonEmptyWords.tail).mkString(" ") + "."
}
