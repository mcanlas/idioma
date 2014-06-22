package com.htmlism.idioma.portuguese

import org.json4s._
import org.json4s.native.JsonMethods._

import com.htmlism.idioma.portuguese.GrammaticalCategories._

object Nouns extends App {
  val json = parse(new java.io.File("data/portuguese/nouns.json"))

  val declensions = json match {
    case JArray(jsonLemmas) =>
      for (jsonLemma <- jsonLemmas) yield {
        val JString(lemma)  = jsonLemma \ "lemma"
        val JString(genderString) = jsonLemma \ "gender"

        val gender = genderString match {
          case "m" => Masculine
          case "f" => Feminine
          case _   => throw new RuntimeException
        }

        Declension(lemma, gender)
      }
    case _ => throw new IllegalArgumentException
  }

  declensions.foreach { d =>
    println(d(Singular))
    println(d(Plural))
  }
}
