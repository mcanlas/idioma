package com.htmlism.idioma.portuguese

import org.json4s._
import org.json4s.native.JsonMethods._
import GrammaticalCategories._

object Main extends App {
  val input = org.json4s.file2JsonInput(new java.io.File("verbs.json"))

  val json = parse(new java.io.File("data/portuguese/verbs.json"))

  for (JArray(verbs) <- json) {
    for (json <- verbs) {
      val verb = Verb(json)

      List(Present, Perfect).flatMap { t =>
        Persons.flatMap { p =>
          Numbers.map { n =>
            val form = verb(t, p, n).word

            (p, n) match {
              case (FirstPerson, Singular) =>
                println(s"eu $form")
              case (ThirdPerson, Singular) =>
                println(s"você $form")
                println(s"ele $form")
                println(s"ela $form")
                println(s"a gente $form")
              case (FirstPerson, Plural) =>
                println(s"nós $form")
              case (ThirdPerson, Plural) =>
                println(s"eles $form")
                println(s"elas $form")
              case _ =>
            }
          }
        }
      }
    }
  }
}
