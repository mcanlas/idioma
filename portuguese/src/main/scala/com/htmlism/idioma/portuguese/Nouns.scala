package com.htmlism.idioma.portuguese

import org.json4s._
import org.json4s.native.JsonMethods._

import com.htmlism.idioma.portuguese.CategoriasGramaticais._

object Nouns extends App {
  val json = parse(getClass.getResourceAsStream("/nouns.json"))

  val declensions = json match {
    case JArray(jsonLemmas) =>
      for (jsonLemma <- jsonLemmas) yield {
        val JString(lemma)        = jsonLemma \ "lemma"
        val JString(genderString) = jsonLemma \ "gender"

        val plural = jsonLemma \ "plural" match {
          case JString(form) => Some(form)
          case JNothing      => None
          case _             => throw new NotImplementedError
        }

        val gender = genderString match {
          case "m" => Masculino
          case "f" => Feminino
          case _   => throw new RuntimeException
        }

        Declension(lemma, gender, plural)
      }
    case _                  => throw new IllegalArgumentException
  }

  declensions.foreach { d =>
    println(d(Singular))
    println(d(Plural))

    println(d(Singular, Indefinitivo))
    println(d(Plural, Indefinitivo))

    println(d(Singular, Definitivo))
    println(d(Plural, Definitivo))
  }
}
