package com.htmlism.idioma

import scala.io.Source

import org.json4s._
import org.json4s.native.JsonMethods._

object NounCards extends TranslationCardIterator {
  def partsIterator: Iterator[(String, String, String)] = {
    val json = Source
      .fromInputStream(getClass.getResourceAsStream("/nouns.json"))
      .mkString

    val nouns = parse(json) match {
      case JObject(jsValues) => jsValues
      case _                 => Nil
    }

    nouns.iterator
      .map { case (english, jvalue) =>
        implicit val formats = DefaultFormats

        val hangul = (jvalue \ "hangul").extract[String]

        (english, english, hangul)
      }
  }
}
