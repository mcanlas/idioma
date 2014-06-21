package com.htmlism.idioma

import org.specs2.mutable.Specification

class PhraseIteratorSpec extends Specification {
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

    val iterator = new PhraseIterator(left, right)

    "have the right magnitude" in {
      iterator.length === 9
    }
  }
}
