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
    case Plural   => {
      val substitution = Declension.substitutions.find { case (ending, _) => lemma.endsWith(ending) }

      substitution match {
        case Some((ending, replacement)) => lemma.replaceFirst(s"$ending$$", replacement)
        case None => throw new RuntimeException
      }
    }
  }
}
