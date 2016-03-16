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

        Seq(
          AnkiCardValue(
            "eng2kor-" + english,
            s"""<div id="preface">$english</div>""",
            s"""<div id="heroic-answer">$korean</div>"""),
          AnkiCardValue(
            "kor2eng-" + english,
            s"""<div id="heroic-answer">$korean</div>""",
            s"""<div id="preface">$english</div>"""))
      }
  }
}
