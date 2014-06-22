package com.htmlism.idioma

class Sentence(words: Seq[String]) {
  def render = (words.head.capitalize +: words.tail).mkString(" ") + "."
}
