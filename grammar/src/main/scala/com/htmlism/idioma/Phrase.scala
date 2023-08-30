package com.htmlism.idioma

object Phrase {
  def empty = Phrase(Nil)

  def apply(words: String): Phrase = Phrase(words.split(" ").toList)
}

case class Phrase(words: List[String]) {
  def +(that: Phrase) = Phrase(words ++ that.words)
}
