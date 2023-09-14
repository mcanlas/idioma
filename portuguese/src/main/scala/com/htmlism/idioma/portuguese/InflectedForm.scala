package com.htmlism.idioma.portuguese

sealed trait InflectedForm:
  def word: String

case class RegularForm(word: String)     extends InflectedForm
case class ConjugationForm(word: String) extends InflectedForm
case class IrregularForm(word: String)   extends InflectedForm
