package com.htmlism.idioma.tagalog

import com.htmlism.idioma._
import org.json4s._
import org.json4s.native.JsonMethods._

object Data {
  lazy val periods = {
    val json = parse(new java.io.File("data/tagalog/nouns.json"))

    val phrases: Seq[Phrase] = for {
      JArray(objects) <- json
      JObject(obj) <- objects
      JField("lemma", JString(lemma)) <- obj
    } yield new Phrase(lemma :: Nil)

    Generator(phrases)
  }
}