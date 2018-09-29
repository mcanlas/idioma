package com.htmlism.idioma

class CombinationGenerator[A, B](left: Iterable[A], right: Iterable[B])
    extends Iterable[(A, B)]
    with CanSample[(A, B)] {
  def iterator = new CombinationIterator(left.iterator, right)

  def sample = (left.sample, right.sample)
}

class CombinationIterator[A, B](leftIterator: Iterator[A], rightGenerator: Iterable[B]) extends Iterator[(A, B)] {
  private var currentLeftElement: A = _
  private var rightIterator         = rightGenerator.iterator

  def hasNext = leftIterator.hasNext || rightIterator.hasNext

  def next() =
    if (hasNext) {
      if (currentLeftElement == null)
        currentLeftElement = leftIterator.next()

      val leftElement  = currentLeftElement
      val rightElement = rightIterator.next()

      if (!rightIterator.hasNext && leftIterator.hasNext) {
        currentLeftElement = leftIterator.next()
        rightIterator = rightGenerator.iterator
      }

      (leftElement, rightElement)
    } else
      throw new RuntimeException("cannot generate combinations with exhausted sources")
}
