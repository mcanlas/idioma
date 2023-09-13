package com.htmlism.idioma

import weaver._

object CompoundGeneratorSuite extends FunSuite {
  val elements = List("earth", "fire", "wind", "water")
  val magi     = List("belthasar", "gaspar", "melchior")

  val generator = elements * magi

  test("have the right magnitude") {
    expect.eql(elements.size * magi.size, generator.size)
  }

  test("yield samples within its sources") {
    val (element, mage) = generator.sample

    expect(elements.contains(element)) and
      expect(magi.contains(mage))
  }

  test("support nesting") {
    val ozzie = List("ozzie")
    val slash = List("slash")
    val flea  = List("flea")

    expect.eql((("ozzie", "slash"), "flea"), (ozzie * slash * flea).sample)
  }
}
