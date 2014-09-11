package com.htmlism.idioma

class SimpleGenerator[A](val elements: Seq[A]) extends Iterable[A] with CanSample[A] {
  def iterator = elements.iterator

  def sample = {
    val randomIndex = (new util.Random).nextInt(elements.size)

    elements(randomIndex)
  }
}
