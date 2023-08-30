package com.htmlism.idioma

trait AnkiCard {
  def id: String

  def front: String

  def back: String

  def serialize(tag: String): String = List(id, front, back, tag).mkString("\t")
}

case class AnkiCardValue(id: String, front: String, back: String) extends AnkiCard
