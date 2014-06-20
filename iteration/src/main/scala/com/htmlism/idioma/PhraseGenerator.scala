package com.htmlism.idioma

object PhraseGenerator {
  // TODO one constructor for simple lists (January, February, March ...)
  def apply(phrases: Seq[Phrase]) = new SimplePhraseGenerator(phrases)

  // TODO one constructor for hybrid lists (blue, $animal)

  // TODO one constructor for multiple generators ($color, $animal)
}

trait PhraseGenerator {
  // TODO should turn an abstract Phraseable type? phrase and phrase generator should share a type?
  def iterator: Iterator[Phrase]
  def sample: Phrase
  def +(phrase: Phrase): PhraseGenerator
  def +(generator: PhraseGenerator): PhraseGenerator
}
