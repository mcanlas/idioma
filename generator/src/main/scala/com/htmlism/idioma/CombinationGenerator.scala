package com.htmlism.idioma

class CombinationGenerator[A, B](left: Generator[A], right: Generator[B]) extends Generator[(A, B)] {
  def iterator = new CombinationIterator(left.iterator, right)

  def sample = (left.sample, right.sample)
}

class CombinationIterator[A, B](leftIterator: Iterator[A], rightGenerator: Generator[B]) extends Iterator[(A, B)] {
  private var currentLeftElement = Option.empty[A]
  private var rightIterator      = rightGenerator.iterator

  def hasNext = leftIterator.hasNext || rightIterator.hasNext

  def next() = if (hasNext) {
    if (currentLeftElement.isEmpty)
      currentLeftElement = Some(leftIterator.next())

    val leftElement  = currentLeftElement.get
    val rightElement = rightIterator.next()

    if (!rightIterator.hasNext && leftIterator.hasNext) {
      currentLeftElement = Some(leftIterator.next())
      rightIterator     = rightGenerator.iterator
    }

    (leftElement, rightElement)
  } else throw new RuntimeException("cannot generate combinations with an exhausted iterator")
}
