package com.htmlism.idioma

trait Sentence:
  protected def words: List[String]
  protected def punctuation: String

  lazy val nonEmptyWords = words.toSeq.filter { _.nonEmpty }

  def render =
    (nonEmptyWords.head.capitalize +: nonEmptyWords.tail)
      .mkString(" ") + punctuation

case class Statement(words: List[String]) extends Sentence:
  protected val punctuation = "."

case class Question(words: List[String]) extends Sentence:
  protected val punctuation = "?"
