package com.htmlism.idioma

import scala.io.Source

import com.htmlism.hangul.Hangul

object GeneratePeriodicTables extends App:
  val romanNumerals = List("I", "II", "III", "IV", "V", "VI")

  printConsonants()
  printVowels()

  private def printConsonants() =
    val consonants =
      val lines = Source
        .fromResource("consonants.csv")
        .getLines()
        .toList

      lines
        .tail
        .iterator
        .map { s =>
          val Array(n, hangul) = s.split(",")

          n.toInt -> hangul
        }
        .toMap

    val lines = Source
      .fromResource("periodic-consonants.tsv")
      .getLines()

    val html =
      val firstRowCellsHtml =
        val headerCellsHtml = lines
          .next()
          .split("\t")
          .map(_.toUpperCase)

        ("" +: headerCellsHtml)
          .map(h => s"""<th>$h</th>""")

      val bodyRowsCellsHtml =
        val bodyCellsHtml = lines.map { row =>
          row
            .split("\t", -1) // negative means keep trailing empty cells
            .map:
              case "" => """<td class="consonant-empty"></td>"""
              case nStr =>
                val n = nStr.toInt

                val character = (Hangul.initialOriginCodePoint + n - 1).toChar
                val name      = consonants(n)

                """<td class="consonant"><div class="consonant-cell">""" +
                  s"""<div class="consonant-sort">$n</div>""" +
                  s"""<div class="consonant-character">$character</div>""" +
                  s"""<div class="consonant-name">$name</div>""" +
                  """</div></td>"""
        }.toSeq

        for (i <- bodyCellsHtml.indices) yield s"""<th>${romanNumerals(i)}</th>""" +: bodyCellsHtml(i)

      (firstRowCellsHtml +: bodyRowsCellsHtml)
        .map(r => r.mkString("\n"))
        .map(r => s"<tr>$r</tr>")
        .mkString("\n")

    println(s"<table>$html</table>")

  private def printVowels() =
    val html =
      val firstRowCellsHtml = List("", "A", "B", "C", "D", "E", "F")
        .map(c => s"<th>$c</th>")

      val bodyRowsCellsHtml =
        val rows =
          val lines = Source
            .fromResource("periodic-vowels.tsv")
            .getLines()
            .toList

          lines.tail.iterator

        val bodyCellsHtml = rows.map { row =>
          row
            .split("\t", -1) // negative means keep trailing empty cells
            .map:
              case "" => """<td class="vowel-empty"></td>"""
              case nStr =>
                val n = nStr.toInt

                val character = (Hangul.medialOriginCodePoint + n - 1).toChar

                """<td class="vowel"><div class="vowel-cell">""" +
                  s"""<div class="vowel-sort">$n</div>""" +
                  s"""<div class="vowel-character">$character</div>""" +
                  """</div></td>"""
            .toSeq
        }.toSeq

        for (i <- bodyCellsHtml.indices) yield s"""<th>${romanNumerals(i)}</th>""" +: bodyCellsHtml(i)

      (firstRowCellsHtml +: bodyRowsCellsHtml)
        .map(r => r.mkString("\n"))
        .map(r => s"<tr>$r</tr>")
        .mkString("\n")

    println(s"<table>$html</table>")
