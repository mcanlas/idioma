package com.htmlism.idioma.portuguese

object Padder:
  def alignLeft(strings: List[String]): List[String] =
    val length = maximumLength(strings)

    strings.map(x => s"%-${length}s".format(x))

  def alignRight(strings: List[String]): List[String] =
    val length = maximumLength(strings)

    strings.map(x => s"%${length}s".format(x))

  def zip(left: Iterable[String], right: Iterable[String]): List[String] =
    zip(1)(left, right)

  def zip(length: Int)(left: Iterable[String], right: Iterable[String]): List[String] =
    val leftIterator  = left.iterator
    val rightIterator = right.iterator

    var lines = List[String]()

    val width = maximumLength(left.toList)

    while leftIterator.hasNext do
      val leftCell  = s"%-${width}s".format(leftIterator.next())
      val rightCell =
        if rightIterator.hasNext then (" " * length) + rightIterator.next() else ""

      val newLine = leftCell + rightCell

      lines = newLine :: lines

    lines.reverse

  def maximumLength(strings: List[String]) =
    strings.foldLeft(0)((acc, e) => if acc > e.length then acc else e.length)
