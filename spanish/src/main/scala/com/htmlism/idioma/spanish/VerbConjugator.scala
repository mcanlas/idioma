package com.htmlism.idioma.spanish

import com.htmlism.idioma.spanish.GrammaticalNumber._
import com.htmlism.idioma.spanish.GrammaticalPerson._

object VerbConjugator:
  def getForm(verb: ParsedVerb, irregularForms: Map[String, String], form: VerbalForm): String =
    val rootAndVowel =
      verb.root + verb.conjugation.vowel

    form match
      case VerbalForm.Infinitive =>
        rootAndVowel + "r"

      case VerbalForm.PastParticiple =>
        rootAndVowel + "do"

      case VerbalForm.Gerund =>
        rootAndVowel + "ndo"

      case VerbalForm.PresentMood(person, number) =>
        (person, number) match
          case (FirstPerson, Singular)  => verb.root + "o"
          case (SecondPerson, Singular) => rootAndVowel + "s"
          case (ThirdPerson, Singular)  => rootAndVowel
          case (FirstPerson, Plural)    => rootAndVowel + "mos"
          case (SecondPerson, Plural) =>
            val suffix = verb.conjugation match
              case VerbConjugation.Ar => "áis"
              case VerbConjugation.Er => "éis"
              case VerbConjugation.Ir => "ís"

            verb.root + suffix
          case (ThirdPerson, Plural) => rootAndVowel + "n"
