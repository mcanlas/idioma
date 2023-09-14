package com.htmlism.idioma.spanish

import com.htmlism.idioma.spanish.GrammaticalNumber._
import com.htmlism.idioma.spanish.GrammaticalPerson._
import com.htmlism.idioma.spanish.GrammaticalTense._

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

      case VerbalFormKey.PresentMood(tense, number, person) =>
        val overrideKey =
          List("indicative", tense.s, person.s, number.s)
            .mkString("-")

        lazy val defaultConjugation =
          tense match
            case Present =>
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

            case Preterite =>
              (person, number) match
                case (FirstPerson, Singular) =>
                  verb.root + (verb.conjugation match
                    case VerbConjugationGroup.Ar                           => "é"
                    case VerbConjugationGroup.Er | VerbConjugationGroup.Ir => "í"
                  )

                case (SecondPerson, Singular) =>
                  verb.root + (verb.conjugation match
                    case VerbConjugationGroup.Ar                           => "aste"
                    case VerbConjugationGroup.Er | VerbConjugationGroup.Ir => "iste"
                  )

                case (ThirdPerson, Singular) =>
                  verb.root + (verb.conjugation match
                    case VerbConjugationGroup.Ar                           => "ó"
                    case VerbConjugationGroup.Er | VerbConjugationGroup.Ir => "ió"
                  )

                case (FirstPerson, Plural) =>
                  verb.root + (verb.conjugation match
                    case VerbConjugationGroup.Ar                           => "amos"
                    case VerbConjugationGroup.Er | VerbConjugationGroup.Ir => "imos"
                  )

                case (SecondPerson, Plural) =>
                  verb.root + (verb.conjugation match
                    case VerbConjugationGroup.Ar                           => "asteis"
                    case VerbConjugationGroup.Er | VerbConjugationGroup.Ir => "isteis"
                  )

                case (ThirdPerson, Plural) =>
                  verb.root + (verb.conjugation match
                    case VerbConjugationGroup.Ar                           => "aron"
                    case VerbConjugationGroup.Er | VerbConjugationGroup.Ir => "ieron"
                  )

        getIrregularFormOrElse(overrideKey, defaultConjugation)
