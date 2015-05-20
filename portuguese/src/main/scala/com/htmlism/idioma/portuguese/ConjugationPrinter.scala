package com.htmlism.idioma.portuguese

import scala.collection.breakOut

import com.htmlism.idioma.portuguese.CategoriasGramaticais._

class ConjugationPrinter(conjugation: Conjugação) {
  def print() = {
    val tempos = Seq(Presente, Imperfeito, Perfeito)

    val tenseBlocks = for (t <- tempos) yield {
      val pronomes =
        for (n <- Números; p <- Pessoas) yield
          Pronomes(n, p).mkString("/")

      val formas =
        for (n <- Números; p <- Pessoas) yield
          conjugation(t, p, n).word

      t.toString :: Padder.zip(
        Padder.alignRight(pronomes),
        Padder.alignLeft(formas))
    }

    tenseBlocks.reduce(Padder.zip(2)).foreach(println)
  }
}

object Padder {
  def alignLeft(strings: Traversable[String]): List[String] = {
    val length = maximumLength(strings)

    strings.map(x => s"%-${length}s".format(x))(breakOut)
  }

  def alignRight(strings: Traversable[String]): List[String] = {
    val length = maximumLength(strings)

    strings.map(x => s"%${length}s".format(x))(breakOut)
  }

  def zip(left: Iterable[String], right: Iterable[String]): List[String] = zip(1)(left, right)

  def zip(length: Int)(left: Iterable[String], right: Iterable[String]): List[String] = {
    val leftIterator  = left.iterator
    val rightIterator = right.iterator

    var lines = List[String]()

    val width = maximumLength(left)

    while (leftIterator.hasNext) {
      val leftCell  = s"%-${width}s".format(leftIterator.next)
      val rightCell = if (rightIterator.hasNext) (" " * length) + rightIterator.next else ""

      val newLine = leftCell + rightCell

      lines = newLine :: lines
    }

    lines.reverse
  }

  def maximumLength(strings: TraversableOnce[String]) = strings.foldLeft(0)((acc, e) => if (acc > e.length) acc else e.length)
}
