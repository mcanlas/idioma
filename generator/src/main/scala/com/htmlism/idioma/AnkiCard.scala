package com.htmlism.idioma

trait AnkiCard {
  def id: String

  def front: String

  def back: String

  def tag: String

  def serialize: String = id + "\t" + front + "\t" + back
}

case class AnkiCardValue(id: String, front: String, back: String) extends AnkiCard {
  def tag: String = ""
}
