package com.htmlism.idioma

import com.htmlism.hangul.Hangul

import scala.io.Source

object GeneratePeriodicTables extends App {
  val romanNumerals = Seq("I", "II", "III", "IV", "V", "VI")

  printConsonants()
  printVowels()

  private def printConsonants() = {
    val consonants = {
      val lines = Source.fromInputStream(getClass.getResourceAsStream("/consonants.csv")).getLines()

      lines.next()

      lines
        .map { s =>
          val Array(n, hangul) = s.split(",")

          n.toInt -> hangul
        }
        .toMap
    }

    val lines = Source.fromInputStream(getClass.getResourceAsStream("/periodic-consonants.tsv")).getLines()

    val html = {
      val firstRowCellsHtml = {
        val headerCellsHtml = lines
          .next()
          .split("\t")
          .map(_.toUpperCase)

        ("" +: headerCellsHtml)
          .map(h => s"""<th>$h</th>""")
      }

      val bodyRowsCellsHtml = {
        val bodyCellsHtml = lines
          .map { row =>
            row
              .split("\t", -1) // negative means keep trailing empty cells
              .map {
                case "" => """<td class="consonant-empty"></td>"""
                case nStr =>
                  val n = nStr.toInt

                  val character = (Hangul.initialOriginCodePoint + n - 1).toChar
                  val name = consonants(n)

                  """<td class="consonant"><div class="consonant-cell">""" +
                    s"""<div class="consonant-sort">$n</div>""" +
                    s"""<div class="consonant-character">$character</div>""" +
                    s"""<div class="consonant-name">$name</div>""" +
                    """</div></td>"""
              }
          }
          .toSeq

        for (i <- bodyCellsHtml.indices) yield {
          s"""<th>${romanNumerals(i)}</th>""" +: bodyCellsHtml(i)
        }
      }

      (firstRowCellsHtml +: bodyRowsCellsHtml)
        .map(r => r.mkString("\n"))
        .map(r => s"<tr>$r</tr>")
        .mkString("\n")
    }

    println(s"<table>$html</table>")
  }

  private def printVowels() = {
    val html = {
      val firstRowCellsHtml = Seq("", "A", "B", "C", "D", "E", "F")
        .map(c => s"<th>$c</th>")

      val bodyRowsCellsHtml = {
        val rows = {
          val lines = Source.fromInputStream(getClass.getResourceAsStream("/periodic-vowels.tsv")).getLines()

          lines.next()

          lines
        }

        val bodyCellsHtml = rows
          .map { row =>
            row
              .split("\t", -1) // negative means keep trailing empty cells
              .map {
                case "" => """<td class="vowel-empty"></td>"""
                case nStr =>
                  val n = nStr.toInt

                  val character = (Hangul.medialOriginCodePoint + n - 1).toChar

                  """<td class="vowel"><div class="vowel-cell">""" +
                    s"""<div class="vowel-sort">$n</div>""" +
                    s"""<div class="vowel-character">$character</div>""" +
                    """</div></td>"""
              }
              .toSeq
          }
        .toSeq

        for (i <- bodyCellsHtml.indices) yield {
          s"""<th>${romanNumerals(i)}</th>""" +: bodyCellsHtml(i)
        }
      }

      (firstRowCellsHtml +: bodyRowsCellsHtml)
        .map(r => r.mkString("\n"))
        .map(r => s"<tr>$r</tr>")
        .mkString("\n")
    }

    println(s"<table>$html</table>")
  }
}
