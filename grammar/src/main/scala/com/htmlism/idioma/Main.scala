package com.htmlism.idioma

import org.json4s._
import org.json4s.native.JsonMethods._

object Main extends App {
  val input = org.json4s.file2JsonInput(new java.io.File("verbs.json"))

  val json = parse(new java.io.File("verbs.json"))

  for (JArray(verbs) <- json) {
    for (json <- verbs) {
      println(Verb(json))
    }
  }
}
