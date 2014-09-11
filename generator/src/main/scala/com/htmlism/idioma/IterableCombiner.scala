package com.htmlism.idioma

class IterableCombiner[A](left: Iterable[A]) {
  def *[B](right: Iterable[B]) = new CombinationGenerator[A, B](left, right)
}
