package com.htmlism.idioma

import org.specs2.mutable.Specification

class PhraseGeneratorSpec extends Specification {
  "A phrase generator of one word" should {
    val phrase = "the world is square".split(" ").toList
    val generator = PhraseGenerator(Seq(phrase))

    "expose its sources" in {
      generator.phrases === phrase :: Nil
    }

    "have a sample equal to its source" in {
      generator.sample === phrase
    }

    "have a simple iterator" in {
      generator.iterator.toList === phrase :: Nil
    }

    "append a simple phrase" in {
      val newPhrase = "dance with me".split(" ").toList
      val newGenerator = generator + newPhrase

      newGenerator.sample === phrase ::: newPhrase
    }
  }

  "A phrase generator of many words" should {
    val phrases = List("earth", "is", "hard") ::
      List("fire", "is", "hot") ::
      List("wind", "is", "soft") ::
      List("water", "is", "wet") ::
      Nil

    val generator = PhraseGenerator(phrases)

    "expose its sources" in {
      generator.phrases === phrases
    }

    "have a sample from its source" in {
      phrases.contains(generator.sample)
    }

    "iterate the right elements" in {
      generator.iterator.toList must containTheSameElementsAs(phrases)
    }

    "append a simple phrase" in {
      val newPhrase = "dance with me".split(" ").toList
      val newGenerator = generator + newPhrase

      newGenerator.sample must contain(allOf(newPhrase: _*))
    }
  }

  "An optional phrase generator" should {
    "have the right magnitude" in {
      val generator = PhraseGenerator(List(List("something")))

      generator.optional.iterator.length === 2
    }
  }
}
