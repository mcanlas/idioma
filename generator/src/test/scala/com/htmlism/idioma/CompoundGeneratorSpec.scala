package com.htmlism.idioma

import org.specs2.mutable.Specification

class CompoundGeneratorSpec extends Specification {
  "A compound generator" should {
    val elements = List("earth", "fire", "wind", "water")
    val magi     = List("belthasar", "gaspar", "melchior")

    val generator = elements * magi

    "have the right magnitude" in {
      generator.size === elements.size * magi.size
    }

    "yield samples within its sources" in {
      val (element, mage) = generator.sample

      elements must contain(element)
      magi must contain(mage)
    }

    "support nesting" in {
      val ozzie = List("ozzie")
      val slash = List("slash")
      val flea  = List("flea")

      (ozzie * slash * flea).sample === ((("ozzie", "slash"), "flea"))
    }
  }
}
