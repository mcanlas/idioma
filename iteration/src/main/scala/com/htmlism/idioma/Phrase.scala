package com.htmlism.idioma

object Phrase {
  def empty = Phrase(Nil)
}

case class Phrase(words: List[String]) {
  def +(that: Phrase) = Phrase(words ::: that.words)
}
