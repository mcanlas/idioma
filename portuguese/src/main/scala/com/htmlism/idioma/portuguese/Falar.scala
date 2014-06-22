package com.htmlism.idioma.portuguese

import com.htmlism.idioma._
import org.json4s._
import org.json4s.native.JsonMethods._

object Falar extends App {
  val idiomas = {
    val json = parse(new java.io.File("data/portuguese/nouns.languages.json"))

    val phrases: Seq[Phrase] = for {
      JArray(objetos) <- json
      JObject(objeto) <- objetos
      JField("noun", JString(palavra)) <- objeto
    } yield Phrase(palavra)

    Generator(phrases)
  }

  idiomas.iterator.foreach { println }
}
