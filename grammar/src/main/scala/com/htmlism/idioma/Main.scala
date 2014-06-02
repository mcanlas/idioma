package com.htmlism.idioma

import org.json4s._
import org.json4s.native.JsonMethods._

object Main extends App {
  val input = org.json4s.file2JsonInput(new java.io.File("verbs.json"))

  val json = parse(new java.io.File("data/portuguese/verbs.json"))

  for (JArray(verbs) <- json) {
    for (json <- verbs) {
      println(Verb(json))
    }
  }

  Conjugation("falar").print()
  Conjugation("comer").print()
  Conjugation("assistir").print()
}
