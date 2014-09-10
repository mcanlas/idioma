package com.htmlism.idioma.portuguese

import com.htmlism.idioma._
import CategoriasGramaticais._

object Main extends App {
  val verbalPhrases = Data.verbs.flatMap { verb =>
    List(Presente, Perfeito, Imperfeito).flatMap { t =>
      val timePhrases = t match {
        case Presente   => Nil :: Nil
        case Perfeito   => List("ontem") :: Nil
        case Imperfeito => List("antigamente") :: List("no", "passado") :: Nil
        case _ => throw new UnsupportedOperationException
      }

      val phrases = Pessoas.flatMap { p =>
        Números.flatMap { n =>
          val form = verb(t, p, n).word

          (p, n) match {
            case (PessoaPrimeira, Singular) =>
              List("eu", form) :: Nil
            case (PessoaTerceira, Singular) =>
              List("você", form) ::
                List("ele", form) ::
                List("ela", form) ::
                List("a", "gente", form) ::
                Nil
            case (PessoaPrimeira, Plural) =>
              List("nós", form) :: Nil
            case (PessoaTerceira, Plural) =>
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
    val copula = Data.verbs.filter{ v => v.infinitive == "estar" }.head

    Data.verbs.flatMap { verb =>
      val phrases = List(Presente, Imperfeito).flatMap { t =>
        Pessoas.flatMap { p =>
          Números.flatMap { n =>
            val form = copula(t, p, n).word

            (p, n) match {
              case (PessoaPrimeira, Singular) =>
                List("eu", form) :: Nil
              case (PessoaTerceira, Singular) =>
                List("você", form) ::
                  List("ele", form) ::
                  List("ela", form) ::
                  List("a", "gente", form) ::
                  Nil
              case (PessoaPrimeira, Plural) =>
                List("nós", form) :: Nil
              case (PessoaTerceira, Plural) =>
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
    val sentence = Statement(s)
    println(sentence.render)
  }
}
