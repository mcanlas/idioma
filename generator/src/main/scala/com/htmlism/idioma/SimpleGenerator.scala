package com.htmlism.idioma

class SimpleGenerator[T](val elements: Seq[T]) extends Generator[T] {
  def iterator = elements.iterator

  def sample = {
    val randomIndex = (new util.Random).nextInt(elements.size)

    elements(randomIndex)
  }
}
