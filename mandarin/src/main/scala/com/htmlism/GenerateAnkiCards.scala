package com.htmlism

import java.io.PrintWriter

import scala.io.Source

object GenerateAnkiCards {
  val tag = util.Random.alphanumeric.take(10).mkString

  def main(args: Array[String]): Unit = {
    val out = new PrintWriter(args(0))

    val lines = Source
      .fromInputStream(getClass.getResourceAsStream("/phrases.tsv"))
      .getLines()

    for (l <- lines)
      out.println(lineToAnki(l))

    out.close()
  }

  def lineToAnki(s: String): String = {
    val id = s.hashCode.toString

    val parts = s.split("\t")

    val chineseText = parts(0).capitalize
    val english =
      if (parts.length > 1)
        parts(1)
      else
        ""

    List(id, wrap(chineseText), wrap(english), tag).mkString("\t")
  }

  def wrap(s: String): String = {
    val x = s.replace("<", "&lt;").replace(">", "&gt;")

    """<div class="pinyin-phrase">""" + x + "</div>"
  }
}
