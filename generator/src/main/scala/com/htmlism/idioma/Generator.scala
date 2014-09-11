package com.htmlism.idioma

object Generator {
  def apply[T](elements: Seq[T]) = new SimpleGenerator[T](elements)
}
