package com.htmlism.idioma

class SimplePhraseGenerator(val phrases: Seq[Phrase]) extends PhraseGenerator {
  def iterator = phrases.iterator

  def sample = {
    val randomIndex = (new util.Random).nextInt(phrases.size)

    phrases(randomIndex)
  }
}
