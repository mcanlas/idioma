package com.htmlism.idioma.portuguese

import org.specs2.mutable.Specification

class PhraseGeneratorSpec extends Specification {
  "A phrase generator of one word" should {
    val phrase = List("the", "world", "is", "square")
    val generator = PhraseGenerator(Seq(phrase))

    "have a sample equal to its source" in {
      generator.sample === phrase
    }

    "have a simple iterator" in {
      generator.iterator.toList === phrase :: Nil
    }
  }

  "A phrase generator of many words" should {
    val phrases = List("earth", "is", "hard") ::
      List("fire", "is", "hot") ::
      List("wind", "is", "soft") ::
      List("water", "is", "wet") ::
      Nil

    val generator = PhraseGenerator(phrases)

    "have a sample from its source" in {
      phrases.contains(generator.sample)
    }

    "iterate the right elements" in {
      generator.iterator.toList must containTheSameElementsAs(phrases)
    }
  }
}
