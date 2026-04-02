package com.htmlism.idioma

trait Sentence:
  protected def words: List[String]
  protected def punctuation: String

  def render: String =
    (words match
      case head :: tail => (head.capitalize +: tail).mkString(" ")
      case Nil          => ""
    ) + punctuation

case class Statement(words: List[String]) extends Sentence:
  protected val punctuation = "."

case class Question(words: List[String]) extends Sentence:
  protected val punctuation = "?"
