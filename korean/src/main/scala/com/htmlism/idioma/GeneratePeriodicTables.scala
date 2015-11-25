package com.htmlism.idioma

import com.htmlism.hangul.Hangul

import scala.io.Source

object GeneratePeriodicTables extends App {
  private val consonants = {
    val lines = Source.fromFile("data/korean/consonants.csv").getLines()

    lines.next()

    lines
      .map { s =>
        val Array(n, hangul) = s.split(",")

        n.toInt -> hangul
      }
      .toMap
  }

  val rows = {
    val lines = Source.fromFile("data/korean/periodic-consonants.tsv").getLines()

    lines.next()

    lines
  }

  for (row <- rows) {
    val rowInKorean = row
      .split("\t")
      .map {
        case "" => ""
        case i => (Hangul.initialOriginCodePoint + i.toInt - 1).toChar
      }
      .mkString("\t")

    println(rowInKorean)
  }
}
