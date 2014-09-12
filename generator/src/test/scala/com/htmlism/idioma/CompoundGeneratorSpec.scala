package com.htmlism.idioma

import org.specs2.mutable.Specification

class CompoundGeneratorSpec extends Specification {
  "A compound generator" should {
    val elements = Seq('earth, 'fire, 'wind, 'water)
    val magi     = Seq('belthasar, 'gaspar, 'melchior)

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
      val ozzie = Seq('ozzie)
      val slash = Seq('slash)
      val flea  = Seq('flea)

      (ozzie * slash * flea).sample === (('ozzie, 'slash), 'flea)
    }
  }
}
