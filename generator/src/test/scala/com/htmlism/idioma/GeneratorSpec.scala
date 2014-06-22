package com.htmlism.idioma

import org.specs2.mutable.Specification

class GeneratorSpec extends Specification {
  "Mapping over a generator" should {
    val source = 1 to 10
    val range  = 2 to 11

    val newGenerator = Generator(source).map { _ + 1 }

    "maintain magnitude" in {
      newGenerator.iterator.size === source.size
    }

    "maintain order" in {
      newGenerator.iterator.toSeq === range
    }

    "have a sample within the range" in {
      range.contains(newGenerator.sample) must beTrue
    }
  }

  "Flat mapping over a generator" should {
    val source = Seq(2, 3)
    val range  = Seq(2, 4, 3, 6, 9)

    val newGenerator = Generator(source).flatMap { max =>
      val source = for (n <- 1 to max) yield n * max

      Generator(source)
    }

    "have the correct magnitude" in {
      newGenerator.iterator.size === source.sum
    }

    "maintain order" in {
      newGenerator.iterator.toSeq === range
    }

    "have a sample within the range" in {
      range.contains(newGenerator.sample) must beTrue
    }
  }
}