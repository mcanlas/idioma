package com.htmlism.idioma

object Generator {
  def apply[T](elements: Seq[T]) = new SimpleGenerator[T](elements)
}

trait Generator[A] {
  def iterator: Iterator[A]
  def sample: A

  def +[B](generator: Generator[B]) = new CombinationGenerator[A, B](this, generator)
}
