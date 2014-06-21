package com.htmlism.idioma

import scala.util.Random

class OptionalPhraseGenerator(generator: PhraseGenerator) extends PhraseGenerator {
  def iterator = new OptionalPhraseIterator(generator.iterator)

  def sample = if ((new Random).nextBoolean()) Phrase.empty else generator.sample
}

class OptionalPhraseIterator(iterator: Iterator[Phrase]) extends Iterator[Phrase] {
  private var hasOption = true

  def hasNext = hasOption || iterator.hasNext

  def next() = if (hasOption) {
    hasOption = false

    Phrase.empty
  } else iterator.next()
}
