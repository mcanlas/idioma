package com.htmlism.idioma.portuguese

object Conjugação {
  private val RootPattern = "(.*)([aeiô])r".r

  def apply(infinitive: String): Option[(String, Conjugation)] =
    infinitive match {
      case RootPattern(root, vowel) =>
        val conjugação = vowel match {
          case "a" => resources.firstConjugation
          case "e" => resources.secondConjugation
          case "i" => resources.thirdConjugation
        }

        Some((root, conjugação))
      case _ => None
    }
}

trait Conjugation {
  def vowel: String

  def pastParticiple(root: String): InflectedForm

  def gerund(root: String): InflectedForm = RegularForm(root + vowel + "ndo")

  def apply(root: String, key: (Tempo, Pessoa, Number)): InflectedForm
}

class FunctionConjugation(val vowel: String,
                          f: ((Tempo, Pessoa, Number)) => String)
    extends Conjugation {
  def pastParticiple(root: String): InflectedForm = ???

  def apply(root: String, key: (Tempo, Pessoa, Number)): InflectedForm =
    RegularForm(root + f(key))
}
