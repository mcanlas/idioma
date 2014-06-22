package com.htmlism.idioma

class Sentence(words: Seq[String]) {
  lazy val nonEmptyWords = words.filter { _.nonEmpty }

  def render = (nonEmptyWords.head.capitalize +: nonEmptyWords.tail).mkString(" ") + "."
}
