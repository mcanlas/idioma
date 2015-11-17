package com.htmlism.idioma

import scala.io.Source

import org.json4s._
import org.json4s.native.JsonMethods._

object NounCards {
  val iterator: Iterator[AnkiCard] = {
    val consonants = Source.fromFile("data/korean/nouns.json").mkString

    val nouns: Iterable[JValue] = for {
      JArray(jsValues) <- parse(consonants)
      jsValue <- jsValues
    } yield jsValue

    nouns
      .iterator
      .flatMap { json =>
        implicit val formats = DefaultFormats

        val gloss    = (json \ "gloss").extract[String]
        val filename = (json \ "filename").extract[String]
        val word     = (json \ "word").extract[String]

        val pic2word = AnkiCardValue(
          s"pic-to-word-$gloss",
          s"""What is this?<div><img src="$filename"></div>""",
          s"""<div id="heroic-answer">$word</div>""")

        val word2pic = AnkiCardValue(
          s"word-to-pic-$gloss",
          s"""What is this mean?<div id="heroic-answer">$word</div>""",
          s"""<div><img src="$filename"></div>""")

        Seq(pic2word, word2pic)
      }
  }
}
