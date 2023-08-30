package com.htmlism

package object idioma {
  implicit def addSampleMethod[A](iterable: Iterable[A]): CanSample[A] =
    new CanSample[A] {
      def sample = {
        val randomIndex = (new util.Random).nextInt(iterable.size)

        iterable.toList(randomIndex)
      }
    }

  implicit def addCombinationOperator[A](iterable: Iterable[A]): IterableCombiner[A] =
    new IterableCombiner(iterable)
}
