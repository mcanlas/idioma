package com.htmlism.idioma.portuguese

import com.htmlism.idioma.portuguese.CategoriasGramaticais._

object Declension {
  val substitutions = Map(
    "m" -> "ns",
    "r" -> "res",
    "e" -> "es",
    "o" -> "os",
    "a" -> "as",
    "ã" -> "ãs",
    "i" -> "is",
    "l" -> "is"
  )
}

case class Declension(lemma: String, gender: Gênero, plural: Option[String] = None) {
  def apply(number: Número) = number match {
    case Singular => lemma
    case Plural   => pluralForm
  }

  def apply(number: Número, definiteness: Especificação) = (gender, number, definiteness) match {
    case (Masculino, Singular, Definite)   => s"o $lemma"
    case (Masculino, Singular, Indefinite) => s"um $lemma"
    case (Masculino, Plural,   Definite)   => s"os $pluralForm"
    case (Masculino, Plural,   Indefinite) => s"uns $pluralForm"
    case (Feminino,  Singular, Definite)   => s"a $lemma"
    case (Feminino,  Singular, Indefinite) => s"uma $lemma"
    case (Feminino,  Plural,   Definite)   => s"as $pluralForm"
    case (Feminino,  Plural,   Indefinite) => s"umas $pluralForm"
  }

  private def pluralForm = plural match {
    case Some(form) => form
    case None =>
      val substitution = Declension.substitutions.find { case (ending, _) => lemma.endsWith(ending)}

      substitution match {
        case Some((ending, replacement)) => lemma.replaceFirst(s"$ending$$", replacement)
        case None => throw new RuntimeException
      }
  }
}
