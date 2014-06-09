package com.htmlism.idioma.portuguese

class SimplePhraseGenerator(phrases: Seq[Phrase]) extends PhraseGenerator {
  def iterator = phrases.iterator

  def sample = {
    val randomIndex = (new util.Random).nextInt(phrases.size)

    phrases(randomIndex)
  }
}
