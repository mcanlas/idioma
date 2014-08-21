package com.htmlism.idioma.portuguese

trait CanConjugate {
  def apply(tense: Tempo, person: Person, number: Number): InflectedForm
}
