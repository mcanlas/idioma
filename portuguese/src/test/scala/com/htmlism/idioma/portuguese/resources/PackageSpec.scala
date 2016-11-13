package com.htmlism.idioma.portuguese.resources

import org.specs2.mutable.Specification

class PackageSpec extends Specification {
  "interpret underscore" >> {
    interpretUnderscore("_") === "first|second|third"
  }

  "expand alternation" >> {
    expandAlternation("apple") === Seq("apple")

    expandAlternation("a|b|c apple") === Seq("a apple", "b apple", "c apple")
  }
}
