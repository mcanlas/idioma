package com.htmlism.idioma.portuguese

import org.json4s._
import org.json4s.native.JsonMethods._

import com.htmlism.idioma._
import com.htmlism.idioma.portuguese.CategoriasGramaticais._

object Data {
  lazy val verbs = Seq("a", "e", "i").flatMap(parseVerbs)

  lazy val idiomas = {
    val json = parse(new java.io.File("data/portuguese/nouns.languages.json"))

    val phrases: Seq[Phrase] = for {
      JArray(objetos) <- json
      JObject(objeto) <- objetos
      JField("noun", JString(palavra)) <- objeto
    } yield Phrase(palavra)

    Generator(phrases)
  }

  lazy val pronouns = Map(
    (Singular, FirstPerson)  -> Seq("eu"),
    (Singular, SecondPerson) -> Seq("tu"),
    (Singular, ThirdPerson)  -> Seq("você", "ele", "ela", "a gente"),
    (Plural,   FirstPerson)  -> Seq("nós"),
    (Plural,   SecondPerson) -> Seq("vós"),
    (Plural,   ThirdPerson)  -> Seq("vocês", "eles", "elas")
  ).mapValues { s => Generator(s.map { Phrase(_) }) }

  lazy val timeHints = Map(
    Present   -> Seq(""),
    Past   -> Seq("ontem"),
    Imperfect -> Seq("antigamente", "no passado"),
    Future    -> Seq("amanhã")
  ).mapValues { s => Generator(s.map { Phrase(_) }) }

  private def parseVerbs(letter: String) = {
    val json = parse(new java.io.File(s"data/portuguese/verbs.${letter}r.json"))

    json match {
      case JArray(jsonVerbs) =>
        for (json <- jsonVerbs) yield Verb(json)
      case _ => throw new IllegalArgumentException
    }
  }
}
