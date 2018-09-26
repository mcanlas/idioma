package com.htmlism.idioma

object SequenceTrainer {
  def train[A](xs: Seq[A]): ((A, A), Iterator[(A, A, A)], (A, A)) =
    if (xs.length < 2)
      throw new IllegalArgumentException(
        "training sequence must have at least two elements")
    else {
      val first = (xs.head, xs(1))
      val last  = (xs(xs.length - 2), xs.last)

      val iter = (0 to xs.length - 3).iterator
        .map { i =>
          (xs(i), xs(i + 1), xs(i + 2))
        }

      (first, iter, last)
    }
}
