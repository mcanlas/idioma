package com.htmlism.idioma.portuguese

import com.htmlism.idioma._
import com.htmlism.idioma.portuguese.CategoriasGramaticais._

object Falar extends App {
  private val formasDeVerbos = Numeros * List(PessoaPrimeira, PessoaTerceira)
  private val tempos         = List('present, 'perfect, 'imperfect, 'future, 'presentProgressive, 'pastProgressive)

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

  def conjugate(tense: Symbol, number: Number, person: Pessoa) =
    tense match {
      case 'present   => Phrase(verb(Presente, person, number).word)
      case 'perfect   => Phrase(verb(Perfeito, person, number).word)
      case 'imperfect => Phrase(verb(Imperfeito, person, number).word)
      case 'future =>
        Phrase(List(auxiliary(Presente, person, number).word, verb.infinitive))
      case 'presentProgressive =>
        Phrase(List(copula(Presente, person, number).word, verb.gerund))
      case 'pastProgressive =>
        Phrase(List(copula(Imperfeito, person, number).word, verb.gerund))
    }

  def adverb(tense: Symbol) =
    tense match {
      case 'present            => Data.timeHints(Presente)
      case 'perfect            => Data.timeHints(Perfeito)
      case 'imperfect          => Data.timeHints(Imperfeito)
      case 'future             => Data.timeHints(Futuro)
      case 'presentProgressive => List(Phrase.empty)
      case 'pastProgressive    => List(Phrase.empty)
    }

  private val verbPhraseTuples = (tempos * formasDeVerbos).flatMap { case (tense, (number, person)) =>
    val verb     = conjugate(tense, number, person)
    val pronouns = Data.pronouns((number, person))

    adverb(tense) * pronouns * List(verb)
  }

  val phrases = (verbPhraseTuples * Data.idiomas).map { case ((((tense, pronoun)), form), idioma) =>
    tense + pronoun + form + idioma
  }

  for (_ <- 1 to 30) { println(Statement(phrases.sample.words).render) }
}
