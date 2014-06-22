package com.htmlism.idioma

object Generator {
  def apply[T](elements: Seq[T]) = new SimpleGenerator[T](elements)
}

trait Generator[A] {
  outer =>

  def iterator: Iterator[A]
  def sample: A

  def +[B](generator: Generator[B]) = new CombinationGenerator[A, B](this, generator)

  def map[B](f: A => B) = new Generator[B] {
    def iterator = outer.iterator.map { f }
    def sample   = f(outer.sample)
  }
}
