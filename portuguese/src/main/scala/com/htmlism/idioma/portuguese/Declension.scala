package com.htmlism.idioma.portuguese

import com.htmlism.idioma.portuguese.CategoriasGramaticais.*

object Declension:
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

case class Declension(lemma: String, gender: Gender, plural: Option[String] = None):
  def apply(number: Number) =
    number match
      case Singular => lemma
      case Plural   => pluralForm

  def apply(number: Number, definiteness: Especificação) =
    (gender, number, definiteness) match
      case (Gender.Masculine, Singular, Definitivo)   => s"o $lemma"
      case (Gender.Masculine, Singular, Indefinitivo) => s"um $lemma"
      case (Gender.Masculine, Plural, Definitivo)     => s"os $pluralForm"
      case (Gender.Masculine, Plural, Indefinitivo)   => s"uns $pluralForm"
      case (Gender.Feminine, Singular, Definitivo)    => s"a $lemma"
      case (Gender.Feminine, Singular, Indefinitivo)  => s"uma $lemma"
      case (Gender.Feminine, Plural, Definitivo)      => s"as $pluralForm"
      case (Gender.Feminine, Plural, Indefinitivo)    => s"umas $pluralForm"
      case _                                          => throw new NotImplementedError

  private def pluralForm =
    plural match
      case Some(form) => form
      case None       =>
        val substitution = Declension.substitutions.find { case (ending, _) =>
          lemma.endsWith(ending)
        }

        substitution match
          case Some((ending, replacement)) =>
            lemma.replaceFirst(s"$ending$$", replacement)
          case None => throw new RuntimeException
