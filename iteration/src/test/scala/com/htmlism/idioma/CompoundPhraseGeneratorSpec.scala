package com.htmlism.idioma

import org.specs2.mutable.Specification

class CompoundPhraseGeneratorSpec extends Specification {
  "A compound generator of two simple generators" should {
    val left = PhraseGenerator(List(
      "i hate",
      "you love",
      "we eat"
    ))

    val right = PhraseGenerator(List(
      "chocolate bunnies",
      "vanilla beans",
      "strawberry ice cream"
    ))

    "have the right magnitude" in {
      (left.optional + right).iterator.length === 12
    }
  }
}
