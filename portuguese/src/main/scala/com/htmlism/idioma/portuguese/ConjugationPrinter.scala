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

    tenseBlocks.reduce(Padder.zip).foreach(println)
  }
}

object Padder {
  def alignLeft(strings: Traversable[String]): List[String] = {
    val length = strings.view.map(_.length).max

    strings.map(x => s"%-${length}s".format(x))(breakOut)
  }

  def alignRight(strings: Traversable[String]): List[String] = {
    val length = strings.view.map(_.length).max

    strings.map(x => s"%${length}s".format(x))(breakOut)
  }

  def zip(left: Iterable[String], right: Iterable[String]): List[String] = {
    val leftIterator  = left.iterator
    val rightIterator = right.iterator

    var lines = List[String]()

    while (leftIterator.hasNext) {
      val newLine = leftIterator.next + (if (rightIterator.hasNext) " " + rightIterator.next else "")

      lines = newLine :: lines
    }

    lines.reverse
  }
}
