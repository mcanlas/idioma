package com.htmlism.idioma

import java.io.PrintWriter

trait AnkiCardGenerator:
  def cards: Iterator[AnkiCard]

  def main(args: Array[String]): Unit =
    val out = new PrintWriter(args(0))
    val tag = util.Random.alphanumeric.take(10).mkString

    for c <- cards do out.println(c.serialize(tag))

    out.close()
