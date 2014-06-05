package com.htmlism.idioma.portuguese

trait CanConjugate {
  def apply(tense: Tense, person: Person, number: Number): InflectedForm
}
