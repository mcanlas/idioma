package com.htmlism.idioma

class CombinationGenerator[A, B](left: Generator[A], right: Generator[B]) extends Generator[(A, B)] {
  def iterator = new CombinationIterator(left.iterator, right)

  def sample = (left.sample, right.sample)
}

class CombinationIterator[A, B](leftIterator: Iterator[A], rightGenerator: Generator[B]) extends Iterator[(A, B)] {
  private var currentLeftElement: A = _
  private var rightIterator         = rightGenerator.iterator

  private var firstTime = true

  def hasNext = leftIterator.hasNext || rightIterator.hasNext

  def next() = if (hasNext) {
    if (firstTime) {
      currentLeftElement = leftIterator.next()
      firstTime = false
    }

    val leftElement  = currentLeftElement
    val rightElement = rightIterator.next()

    if (!rightIterator.hasNext && leftIterator.hasNext) {
      currentLeftElement = leftIterator.next()
      rightIterator      = rightGenerator.iterator
    }

    (leftElement, rightElement)
  } else throw new RuntimeException("cannot generate combinations with an exhausted iterator")
}
