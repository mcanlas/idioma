package com.htmlism.idioma.portuguese

import org.json4s._
import org.json4s.native.JsonMethods._
import GrammaticalCategories._

object Main extends App {
  val input = org.json4s.file2JsonInput(new java.io.File("verbs.json"))

  val json = parse(new java.io.File("data/portuguese/verbs.json"))

  val verbs = json match {
    case JArray(jsonVerbs) =>
      for (json <- jsonVerbs) yield Verb(json)
    case _ => throw new IllegalArgumentException
  }

  val sentences = verbs.flatMap { verb =>
    List(Present, Perfect).flatMap { t =>
      val time = if (t == Perfect) List("ontem,") else Nil

      val phrases = Persons.flatMap { p =>
        Numbers.flatMap { n =>
          val form = verb(t, p, n).word

          (p, n) match {
            case (FirstPerson, Singular) =>
              List("eu", form) :: Nil
            case (ThirdPerson, Singular) =>
              List("você", form) ::
                List("ele", form) ::
                List("ela", form) ::
                List("a", "gente", form) ::
                Nil
            case (FirstPerson, Plural) =>
              List("nós", form) :: Nil
            case (ThirdPerson, Plural) =>
              List("vocês", form) ::
              List("eles", form) ::
              List("elas", form) :: Nil
            case _ =>
              Nil
          }
        }
      }

      phrases.map { p => time ::: p }
    }
  }

  for (s <- sentences) printSentence(s)

  def printSentence(words: List[String]) = println(words.mkString(" "))
}
