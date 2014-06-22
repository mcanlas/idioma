package com.htmlism.idioma.portuguese

import org.json4s._
import org.json4s.native.JsonMethods._

import com.htmlism.idioma._

object Data {
  lazy val verbs = {
    val json = parse(new java.io.File("data/portuguese/verbs.json"))

    json match {
      case JArray(jsonVerbs) =>
        for (json <- jsonVerbs) yield Verb(json)
      case _ => throw new IllegalArgumentException
    }
  }

  lazy val idiomas = {
    val json = parse(new java.io.File("data/portuguese/nouns.languages.json"))

    val phrases: Seq[Phrase] = for {
      JArray(objetos) <- json
      JObject(objeto) <- objetos
      JField("noun", JString(palavra)) <- objeto
    } yield Phrase(palavra)

    Generator(phrases)
  }
}
