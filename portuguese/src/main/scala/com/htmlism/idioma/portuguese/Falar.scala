package com.htmlism.idioma.portuguese

import com.htmlism.idioma._
import com.htmlism.idioma.portuguese.CategoriasGramaticais._

object Falar extends App {
  private val formasDeVerbos = Numeros * List(PessoaPrimeira, PessoaTerceira)

  val verb = Data
    .verbs
    .filter { v =>
      v.infinitive == "falar"
    }
    .head
  val copula = Data
    .verbs
    .filter { v =>
      v.infinitive == "estar"
    }
    .head
  val auxiliary = Data
    .verbs
    .filter { v =>
      v.infinitive == "ir"
    }
    .head

  def conjugate(tense: Tense, number: Number, person: Pessoa) =
    tense match {
      case Tense.Present   => Phrase(verb(Presente, person, number).word)
      case Tense.Perfect   => Phrase(verb(Perfeito, person, number).word)
      case Tense.Imperfect => Phrase(verb(Imperfeito, person, number).word)
      case Tense.Future =>
        Phrase(List(auxiliary(Presente, person, number).word, verb.infinitive))
      case Tense.PresentProgressive =>
        Phrase(List(copula(Presente, person, number).word, verb.gerund))
      case Tense.PastProgressive =>
        Phrase(List(copula(Imperfeito, person, number).word, verb.gerund))
    }

  def adverb(tense: Tense) =
    tense match {
      case Tense.Present            => Data.timeHints(Presente)
      case Tense.Perfect            => Data.timeHints(Perfeito)
      case Tense.Imperfect          => Data.timeHints(Imperfeito)
      case Tense.Future             => Data.timeHints(Futuro)
      case Tense.PresentProgressive => List(Phrase.empty)
      case Tense.PastProgressive    => List(Phrase.empty)
    }

  private val verbPhraseTuples = (Tense.all * formasDeVerbos).flatMap { case (tense, (number, person)) =>
    val verb     = conjugate(tense, number, person)
    val pronouns = Data.pronouns((number, person))

    adverb(tense) * pronouns * List(verb)
  }

  val phrases = (verbPhraseTuples * Data.idiomas).map { case ((((tense, pronoun)), form), idioma) =>
    tense + pronoun + form + idioma
  }

  for (_ <- 1 to 30) { println(Statement(phrases.sample.words).render) }

  sealed trait Tense

  object Tense {
    val all: List[Tense] =
      List(
        Present,
        Perfect,
        Imperfect,
        Future,
        PresentProgressive,
        PastProgressive
      )

    case object Present            extends Tense
    case object Perfect            extends Tense
    case object Imperfect          extends Tense
    case object Future             extends Tense
    case object PresentProgressive extends Tense
    case object PastProgressive    extends Tense
  }
}
