package com.htmlism.idioma.portuguese

import com.htmlism.idioma.portuguese.GrammaticalCategories._

object Declension {
  val substitutions = Map(
    "m" -> "ns",
    "r" -> "res",
    "e" -> "es",
    "o" -> "os",
    "a" -> "as",
    "ã" -> "ãs",
    "l" -> "is"
  )
}

case class Declension(lemma: String, gender: Gender) {
  def apply(number: Number) = number match {
    case Singular => lemma
    case Plural   => pluralForm
  }

  def apply(number: Number, definiteness: Definiteness) = (gender, number, definiteness) match {
    case (Masculine, Singular, Definite)   => s"o $lemma"
    case (Masculine, Singular, Indefinite) => s"um $lemma"
    case (Masculine, Plural,   Definite)   => s"os $pluralForm"
    case (Masculine, Plural,   Indefinite) => s"uns $pluralForm"
    case (Feminine,  Singular, Definite)   => s"a $lemma"
    case (Feminine,  Singular, Indefinite) => s"uma $lemma"
    case (Feminine,  Plural,   Definite)   => s"as $pluralForm"
    case (Feminine,  Plural,   Indefinite) => s"umas $pluralForm"
  }

  private def pluralForm = {
    val substitution = Declension.substitutions.find { case (ending, _) => lemma.endsWith(ending) }

    substitution match {
      case Some((ending, replacement)) => lemma.replaceFirst(s"$ending$$", replacement)
      case None => throw new RuntimeException
    }
  }
}
