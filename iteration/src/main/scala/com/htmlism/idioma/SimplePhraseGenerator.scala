package com.htmlism.idioma

class SimplePhraseGenerator(phrases: Seq[Phrase]) extends PhraseGenerator {
  def iterator = phrases.iterator

  def sample = {
    val randomIndex = (new util.Random).nextInt(phrases.size)

    phrases(randomIndex)
  }

  def +(phrase: Phrase) = {
    val newPhrases = phrases.map { p => p ::: phrase }

    PhraseGenerator(newPhrases)
  }

  def +(generator: PhraseGenerator) = ???
}
