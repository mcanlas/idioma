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

  val verbalPhrases = verbs.flatMap { verb =>
    List(Present, Perfect, Imperfect).flatMap { t =>
      val timePhrases = t match {
        case Present   => Nil :: Nil
        case Perfect   => List("ontem") :: Nil
        case Imperfect => List("antigamente") :: List("no", "passado") :: Nil
        case _ => throw new UnsupportedOperationException
      }

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

      timePhrases.flatMap { t =>
        phrases.map { p => t ::: p }
      }
    }
  }

  val progressivePhrases = {
    val copula = verbs.filter{ v => v.infinitive == "estar" }.head

    verbs.flatMap { verb =>
      val phrases = List(Present, Imperfect).flatMap { t =>
        Persons.flatMap { p =>
          Numbers.flatMap { n =>
            val form = copula(t, p, n).word

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
      }

      phrases.map { p => p :+ verb.gerund }
    }
  }

  val sentences = verbalPhrases ++ progressivePhrases

  for (s <- sentences) {
    val sentence = new Sentence(s)
    println(sentence.render)
  }
}
