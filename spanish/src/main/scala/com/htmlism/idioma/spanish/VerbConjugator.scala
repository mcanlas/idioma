package com.htmlism.idioma.spanish

import com.htmlism.idioma.spanish.GrammaticalNumber._
import com.htmlism.idioma.spanish.GrammaticalPerson._

object VerbConjugator:
  def getForm(verb: ParsedVerb, irregularForms: Map[String, String], formKey: VerbalFormKey): VerbalForm =
    val rootAndVowel =
      verb.root + verb.conjugation.vowel

    formKey match
      case VerbalFormKey.Infinitive =>
        VerbalForm.Regular(rootAndVowel + "r")

      case VerbalFormKey.PastParticiple =>
        VerbalForm.Regular(rootAndVowel + "do")

      case VerbalFormKey.Gerund =>
        VerbalForm.Regular(rootAndVowel + "ndo")

      case VerbalFormKey.PresentMood(person, number) =>
        val overrideKey =
          List("indicative", "present", person.s, number.s)
            .mkString("-")

        lazy val defaultConjugation =
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

        irregularForms.get(overrideKey) match
          case Some(s) =>
            VerbalForm.Irregular(s)

          case None =>
            VerbalForm.Regular(defaultConjugation)
