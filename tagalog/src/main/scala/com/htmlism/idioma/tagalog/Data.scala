package com.htmlism.idioma.tagalog

import org.json4s._
import org.json4s.native.JsonMethods._

import com.htmlism.idioma._

object Data {
  lazy val periods = {
    val json = parse(getClass.getResourceAsStream("/nouns.json"))

    val phrases: Seq[Phrase] = for {
      JArray(objects)                 <- json
      JObject(obj)                    <- objects
      JField("lemma", JString(lemma)) <- obj
    } yield new Phrase(lemma :: Nil)

    phrases
  }
}
