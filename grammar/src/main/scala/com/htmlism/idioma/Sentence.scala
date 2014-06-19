package com.htmlism.idioma

class Sentence(words: List[String]) {
  def render = (words.head.capitalize :: words.tail).mkString(" ") + "."
}
