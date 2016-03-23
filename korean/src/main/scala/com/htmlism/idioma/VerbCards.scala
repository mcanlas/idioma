package com.htmlism.idioma

import scala.io.Source

import org.json4s._
import org.json4s.native.JsonMethods._

object VerbCards {
  val iterator: Iterator[AnkiCard] = {
    val verbs = Source.fromFile("data/korean/verbs.json").mkString

    // : Iterable[(String, JValue)]

    val nouns = parse(verbs) match {
      case JObject(jsValues) => jsValues
    }

    nouns
      .iterator
      .flatMap { case (english, json) =>
        implicit val formats = DefaultFormats

        val korean = (json \ "korean").extract[String]

        GenerateAnkiCards.translationCards(english, "to " + english, korean)
      }
  }
}
