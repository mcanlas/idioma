package com.htmlism.idioma

class CompoundPhraseGenerator(left: PhraseGenerator, right: PhraseGenerator) extends PhraseGenerator {
  def iterator = ???

  def sample = left.sample ::: right.sample

  def +(phrase: Phrase) = {
    val generator = PhraseGenerator(phrase :: Nil)

    new CompoundPhraseGenerator(this, generator)
  }
}
