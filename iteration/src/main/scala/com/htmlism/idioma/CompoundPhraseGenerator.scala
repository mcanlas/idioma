package com.htmlism.idioma

class CompoundPhraseGenerator(left: PhraseGenerator, right: PhraseGenerator) extends PhraseGenerator {
  def iterator = new PhraseIterator(left, right)

  def sample = left.sample ::: right.sample
}
