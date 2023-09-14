package com.htmlism.idioma.portuguese.resources

import weaver._

object PackageSuite extends FunSuite:
  test("interpret underscore"):
    expect.eql("first|second|third", expandUnderscore("_"))

  test("expand alternation"):
    expect.eql(List("apple"), expandAlternation("apple")) and
      expect.eql(List("a apple", "b apple", "c apple"), expandAlternation("a|b|c apple")) and
      expect.eql(List("a c", "a d", "b c", "b d"), expandAlternation("a|b c|d"))
