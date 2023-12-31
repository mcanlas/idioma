package com.htmlism.idioma

import scala.compiletime.uninitialized

class CombinationGenerator[A, B](left: Iterable[A], right: Iterable[B]) extends Iterable[(A, B)] with CanSample[(A, B)]:
  def iterator = new CombinationIterator(left.iterator, right)

  def sample = (left.sample, right.sample)

class CombinationIterator[A, B](leftIterator: Iterator[A], rightGenerator: Iterable[B]) extends Iterator[(A, B)]:
  private var currentLeftElement: A = uninitialized
  private var rightIterator         = rightGenerator.iterator

  def hasNext = leftIterator.hasNext || rightIterator.hasNext

  def next() =
    if hasNext then
      if currentLeftElement == null then currentLeftElement = leftIterator.next()

      val leftElement  = currentLeftElement
      val rightElement = rightIterator.next()

      if !rightIterator.hasNext && leftIterator.hasNext then
        currentLeftElement = leftIterator.next()
        rightIterator      = rightGenerator.iterator

      (leftElement, rightElement)
    else throw new RuntimeException("cannot generate combinations with exhausted sources")
