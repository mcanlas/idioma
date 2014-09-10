package com.htmlism.idioma

import org.specs2.mutable.Specification

class CompoundGeneratorSpec extends Specification {
  "A compound generator" should {
    val elements = Seq('earth, 'fire, 'wind, 'water)
    val magi     = Seq('belthasar, 'gaspar, 'melchior)

    val elementsGenerator = Generator(elements)
    val magiGenerator     = Generator(magi)

    val generator = elementsGenerator * magiGenerator

    "have the right magnitude" in {
      generator.iterator.size === elements.size * magi.size
    }

    "yield samples within its sources" in {
      val (element, mage) = generator.sample

      elements.contains(element) must beTrue
      magi.contains(mage)        must beTrue
    }

    "support nesting" in {
      val ozzie = Generator(Seq('ozzie))
      val slash = Generator(Seq('slash))
      val flea  = Generator(Seq('flea))

      (ozzie * slash * flea).sample === (('ozzie, 'slash), 'flea)
    }
  }
}
