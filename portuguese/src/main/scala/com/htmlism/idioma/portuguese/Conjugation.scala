package com.htmlism.idioma.portuguese

object Conjugação:
  private val ConjugationVowelPattern = "a|e|i"
  private val RootPattern             = s"(.*)($ConjugationVowelPattern)r".r

  private lazy val conjugations = Map(
    "a" -> resources.firstConjugation,
    "e" -> resources.secondConjugation,
    "i" -> resources.thirdConjugation
  )

  def apply(infinitive: String): Option[(String, Conjugation)] =
    infinitive match
      case RootPattern(root, vowel) =>
        conjugations
          .get(vowel)
          .map(root -> _)

      case _ => None

trait Conjugation:
  def vowel: String

  def pastParticiple(root: String): InflectedForm

  def gerund(root: String): InflectedForm = RegularForm(root + vowel + "ndo")

  def apply(root: String, key: (Tempo, Pessoa, Number)): InflectedForm

class FunctionConjugation(val vowel: String, f: ((Tempo, Pessoa, Number)) => String) extends Conjugation:
  def pastParticiple(root: String): InflectedForm = ???

  def apply(root: String, key: (Tempo, Pessoa, Number)): InflectedForm =
    RegularForm(root + f(key))
