package com.htmlism.idioma.portuguese

trait CanConjugate {
  def apply(tense: Tempo, person: Pessoa, number: Número): InflectedForm
}
