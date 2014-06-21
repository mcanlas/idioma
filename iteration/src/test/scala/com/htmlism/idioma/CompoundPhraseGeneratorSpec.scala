package com.htmlism.idioma

import org.specs2.mutable.Specification

class CompoundPhraseGeneratorSpec extends Specification {
  "A compound generator of two simple generators" should {
    val left = PhraseGenerator(List(
      List("i", "hate"),
      List("you", "love"),
      List("we", "eat")
    ))

    val right = PhraseGenerator(List(
      List("chocolate", "bunnies"),
      List("vanilla", "beans"),
      List("strawberry", "ice", "cream")
    ))

    val generator = PhraseGenerator(left, right)

//    "have the right magnitude" in {
//      generator.iterator.length === 9
//    }
  }
}
