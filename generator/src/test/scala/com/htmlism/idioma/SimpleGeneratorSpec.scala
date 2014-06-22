package com.htmlism.idioma

import org.specs2.mutable.Specification

class SimpleGeneratorSpec extends Specification {
  "A simple generator of one element" should {
    val source = Seq(42)
    val generator = Generator(source)

    "yield a sequence equal to its source" in {
      generator.iterator.toSeq === source
    }

    "have a sample equal to its source" in {
      generator.sample === source.head
    }
  }

  "A simple generator of many elements" should {
    val source = Seq('courage, 'wisdom, 'power)
    val generator = Generator(source)

    "yield a sequence equal to its source" in {
      generator.iterator.toSeq === source
    }

    "have a sample within its source" in {
      source.contains(generator.sample) must beTrue
    }
  }
}
