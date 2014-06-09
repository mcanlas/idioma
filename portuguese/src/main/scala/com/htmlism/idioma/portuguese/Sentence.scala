package com.htmlism.idioma.portuguese

class Sentence(words: List[String]) {
  def render = (words.head.capitalize :: words.tail).mkString(" ") + "."
}
