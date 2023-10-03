package com.htmlism.idioma.portuguese

import cats.syntax.all.*
import org.json4s.*
import org.json4s.native.JsonMethods.*

import com.htmlism.idioma.*

object Data:
  lazy val verbs = List("a", "e", "i").flatMap(parseVerbs)

  lazy val idiomas: List[Phrase] =
    val json = parse(getClass.getResourceAsStream("/nouns.languages.json"))

    json
      .children
      .map(_ \ "noun")
      .map(_.toString)
      .map(Phrase(_))

  lazy val pronouns: Map[(Number, Pessoa), List[Phrase]] = Map(
    (Singular, PessoaPrimeira) -> List("eu"),
    (Singular, PessoaSegunda)  -> List("tu"),
    (Singular, PessoaTerceira) -> List("você", "ele", "ela", "a gente"),
    (Plural, PessoaPrimeira)   -> List("nós"),
    (Plural, PessoaSegunda)    -> List("vós"),
    (Plural, PessoaTerceira)   -> List("vocês", "eles", "elas")
  ).fmap { s =>
    s.map { Phrase(_) }
  }

  lazy val timeHints: Map[Tempo, List[Phrase]] = Map(
    Presente   -> List(""),
    Perfeito   -> List("ontem"),
    Imperfeito -> List("antigamente", "no passado"),
    Futuro     -> List("amanhã")
  ).fmap { s =>
    s.map { Phrase(_) }
  }

  private def parseVerbs(letter: String) =
    val json = parse(getClass.getResourceAsStream(s"/verbs.${letter}r.json"))

    json match
      case JArray(jsonVerbs) =>
        for (json <- jsonVerbs) yield OldVerb(json)
      case _ => throw new IllegalArgumentException
