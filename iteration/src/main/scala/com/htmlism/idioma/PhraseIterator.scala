package com.htmlism.idioma

class PhraseIterator(left: PhraseGenerator, right: PhraseGenerator) extends Iterator[Phrase] {
  private val leftIterator = left.iterator

  private var currentLeftPhrase = Option.empty[Phrase]
  private var rightIterator     = right.iterator

  def hasNext = leftIterator.hasNext || rightIterator.hasNext

  def next() = if (hasNext) {
    if (currentLeftPhrase.isEmpty)
      currentLeftPhrase = Some(leftIterator.next())

    val leftPhrase  = currentLeftPhrase.get
    val rightPhrase = rightIterator.next()

    if (!rightIterator.hasNext && leftIterator.hasNext) {
      currentLeftPhrase = Some(leftIterator.next())
      rightIterator     = right.iterator
    }

    leftPhrase + rightPhrase
  } else throw new RuntimeException("cannot generate phrases with an exhausted iterator")
}
