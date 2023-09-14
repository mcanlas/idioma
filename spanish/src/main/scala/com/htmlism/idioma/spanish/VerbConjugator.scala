package com.htmlism.idioma.spanish

import com.htmlism.idioma.spanish.GrammaticalNumber._
import com.htmlism.idioma.spanish.GrammaticalPerson._

object VerbConjugator:
  def getForm(verb: ParsedVerb, irregularForms: Map[String, String], formKey: VerbalFormKey): VerbalForm =
    def getIrregularFormOrElse(key: String, default: String) =
      irregularForms.get(key) match
        case Some(s) =>
          VerbalForm.Irregular(s)

        case None =>
          VerbalForm.Regular(default)

    val rootAndVowel =
      verb.root + verb.conjugation.vowel

    formKey match
      case VerbalFormKey.Infinitive =>
        VerbalForm.Regular(rootAndVowel + "r")

      case VerbalFormKey.PastParticiple =>
        getIrregularFormOrElse("past-participle", rootAndVowel + "do")

      case VerbalFormKey.Gerund =>
        getIrregularFormOrElse("gerund", rootAndVowel + "ndo")

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

        getIrregularFormOrElse(overrideKey, defaultConjugation)
