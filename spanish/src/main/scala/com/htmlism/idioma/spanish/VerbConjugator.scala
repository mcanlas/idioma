package com.htmlism.idioma.spanish

import com.htmlism.idioma.spanish.GrammaticalNumber._
import com.htmlism.idioma.spanish.GrammaticalPerson._

case class VerbConjugator(verb: ParsedVerb, irregularForms: Map[String, String]):

  private val rootAndVowel =
    verb.root + verb.conjugation.vowel

  def getForm(form: VerbalForm): String =
    form match
      case VerbalForm.Infinitive =>
        rootAndVowel + "r"

      case VerbalForm.PastParticiple =>
        rootAndVowel + "do"

      case VerbalForm.Gerund =>
        rootAndVowel + "ndo"

      case VerbalForm.PresentMood(person, number) =>
        val overrideKey =
          List("indicative", "present", person.s, number.s)
            .mkString("-")

        irregularForms.getOrElse(overrideKey, defaultConjugation(person, number))

  def defaultConjugation(person: GrammaticalPerson, number: GrammaticalNumber) =
    (person, number) match
      case (FirstPerson, Singular)  => verb.root + "o"
      case (SecondPerson, Singular) => rootAndVowel + "s"
      case (ThirdPerson, Singular)  => rootAndVowel
      case (FirstPerson, Plural)    => rootAndVowel + "mos"
      case (SecondPerson, Plural) =>
        val suffix = verb.conjugation match
          case VerbConjugationGroup.Ar => "áis"
          case VerbConjugationGroup.Er => "éis"
          case VerbConjugationGroup.Ir => "ís"

        verb.root + suffix
      case (ThirdPerson, Plural) => rootAndVowel + "n"
