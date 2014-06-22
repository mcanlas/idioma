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

  (tenses + verbForms + Data.idiomas).iterator.map { case ((tense, (number, person)), language) =>
    val verb = conjugate(tense, number, person)

    verb + language
  }.foreach { p => println(new Sentence(p.words).render) }
}
