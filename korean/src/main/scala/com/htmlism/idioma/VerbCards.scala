package com.htmlism.idioma

import scala.io.Source

import org.json4s._
import org.json4s.native.JsonMethods._

object VerbCards extends TranslationCardIterator {
  def partsIterator: Iterator[(String, String, String)] = {
    val verbs = Source
      .fromInputStream(getClass.getResourceAsStream("/verbs.json"))
      .mkString

    // : Iterable[(String, JValue)]

    val nouns = parse(verbs) match {
      case JObject(jsValues) => jsValues
      case _                 => Nil
    }

    nouns.iterator
      .map { case (english, json) =>
        implicit val formats = DefaultFormats

        val korean = (json \ "korean").extract[String]

        (english, "to " + english, korean)
      }
  }
}
