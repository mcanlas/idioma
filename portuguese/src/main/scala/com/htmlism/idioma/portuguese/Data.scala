package com.htmlism.idioma.portuguese

import org.json4s._
import org.json4s.native.JsonMethods._

import com.htmlism.idioma._

object Data {
  lazy val verbs = Seq("a", "e", "i").flatMap(parseVerbs)

  lazy val idiomas = {
    val json = parse(getClass.getResourceAsStream("/nouns.languages.json"))

    val phrases: Seq[Phrase] = for {
      JArray(objetos) <- json
      JObject(objeto) <- objetos
      JField("noun", JString(palavra)) <- objeto
    } yield Phrase(palavra)

    phrases
  }

  lazy val pronouns = Map(
    (Singular, PessoaPrimeira) -> Seq("eu"),
    (Singular, PessoaSegunda)  -> Seq("tu"),
    (Singular, PessoaTerceira) -> Seq("você", "ele", "ela", "a gente"),
    (Plural,   PessoaPrimeira) -> Seq("nós"),
    (Plural,   PessoaSegunda)  -> Seq("vós"),
    (Plural,   PessoaTerceira) -> Seq("vocês", "eles", "elas")
  ).mapValues { s => s.map { Phrase(_) } }

  lazy val timeHints = Map(
    Presente   -> Seq(""),
    Perfeito   -> Seq("ontem"),
    Imperfeito -> Seq("antigamente", "no passado"),
    Futuro    -> Seq("amanhã")
  ).mapValues { s => s.map { Phrase(_) } }

  private def parseVerbs(letter: String) = {
    val json = parse(getClass.getResourceAsStream(s"/verbs.${letter}r.json"))

    json match {
      case JArray(jsonVerbs) =>
        for (json <- jsonVerbs) yield OldVerb(json)
      case _ => throw new IllegalArgumentException
    }
  }
}
