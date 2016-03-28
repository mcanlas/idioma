package com.htmlism.idioma

import scala.io.Source

import org.json4s._
import org.json4s.native.JsonMethods._

object NounCards {
  val iterator: Iterator[AnkiCard] = {
    val json = Source.fromFile("data/korean/nouns.json").mkString

    val nouns = parse(json) match {
      case JObject(jsValues) => jsValues
    }

    nouns
      .iterator
      .flatMap { case (english, jvalue) =>
        implicit val formats = DefaultFormats

        val hangul = (jvalue \ "hangul").extract[String]

        GenerateAnkiCards.translationCards(english, english, hangul)
      }
  }
}
