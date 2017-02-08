package com.htmlism.idioma

import java.io.PrintWriter

trait AnkiCardGenerator {
  def cards: Iterator[AnkiCard]

  def main(args: Array[String]): Unit = {
    val out = new PrintWriter(args(0))

    for (c <- cards)
      out.print(c.serialize)

    out.close()
  }
}
