package com.htmlism.idioma.portuguese

import com.htmlism.idioma._
import com.htmlism.idioma.portuguese.GrammaticalCategories._

object Falar extends App {
  val verbForms = Generator(Seq(Singular, Plural)) + Generator(Seq(FirstPerson, ThirdPerson))
  val tenses    = Generator(Seq('present, 'perfect, 'imperfect, 'future, 'presentProgressive, 'pastProgressive))

  val verb      = Data.verbs.filter{ v => v.infinitive == "falar" }.head
  val copula    = Data.verbs.filter{ v => v.infinitive == "estar" }.head
  val auxiliary = Data.verbs.filter{ v => v.infinitive == "ir" }.head

  def conjugate(tense: Symbol, number: Number, person: Person) = tense match {
    case 'present   => Phrase(verb(Present, person, number).word)
    case 'perfect   => Phrase(verb(Perfect, person, number).word)
    case 'imperfect => Phrase(verb(Imperfect, person, number).word)
    case 'future    => Phrase(Seq(auxiliary(Present, person, number).word, verb.infinitive))
    case 'presentProgressive => Phrase(Seq(copula(Present, person, number).word,   verb.gerund))
    case 'pastProgressive    => Phrase(Seq(copula(Imperfect, person, number).word, verb.gerund))
  }

  def adverb(tense: Symbol) = tense match {
    case 'present   => Data.timeHints(Present)
    case 'perfect   => Data.timeHints(Perfect)
    case 'imperfect => Data.timeHints(Imperfect)
    case 'future    => Data.timeHints(Future)
    case 'presentProgressive => Generator(Seq(Phrase.empty))
    case 'pastProgressive    => Generator(Seq(Phrase.empty))
  }

  val verbPhraseTuples = (tenses + verbForms).flatMap { case (tense, (number, person)) =>
    val verb = conjugate(tense, number, person)
    val pronouns = Data.pronouns(number, person)

    adverb(tense) + pronouns + Generator(Seq(verb))
  }

  val phrases = (verbPhraseTuples + Data.idiomas).map {
    case ((((tense, pronoun)), form), idioma) => tense + pronoun + form + idioma
  }

  phrases.iterator.foreach { p => println(new Sentence(p.words).render) }
}
