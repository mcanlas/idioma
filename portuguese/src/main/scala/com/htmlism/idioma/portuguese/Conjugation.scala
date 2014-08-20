package com.htmlism.idioma.portuguese

import com.htmlism.idioma.portuguese.CategoriasGramaticais._

object Conjugation {
  private val RootPattern = "(.*)([aei])r".r

  def apply(infinitive: String) = infinitive match {
    case RootPattern(root, vowel) => vowel match {
      case "a" => new FirstConjugation(root)
      case "e" => new SecondConjugation(root)
      case "i" => new ThirdConjugation(root)
      case _   => throw new IllegalArgumentException(s"could not determine root for infinitive '$infinitive'")
    }
  }
}

trait Conjugation extends CanConjugate {
  protected val root: String
  protected val vowel: String
  protected val regularForms: Map[(Tense, Person, Number), InflectedForm]

  def apply(tense: Tense, person: Person, number: Number) = regularForms((tense, person, number))

  lazy val rootVowel = root + vowel

  lazy val gerund = rootVowel + "ndo"

  lazy val veryRegularForms = Map(
    (Present, FirstPerson, Singular) -> r(root + "o"),
    (Present, FirstPerson, Plural)   -> r(rootVowel + "mos"),

    (Past, SecondPerson, Singular) -> r(rootVowel + "ste"),
    (Past, FirstPerson,  Plural)   -> r(rootVowel + "mos"),
    (Past, SecondPerson, Plural)   -> r(rootVowel + "stes"),
    (Past, ThirdPerson,  Plural)   -> r(rootVowel + "ram")
  )

  // Pluperfect
  lazy val firstPersonSingularPluperfect  = rootVowel + "ra"
  lazy val secondPersonSingularPluperfect = rootVowel + "ras"
  lazy val thirdPersonSingularPluperfect  = rootVowel + "ra"
       val firstPersonPluralPluperfect:   String
       val secondPersonPluralPluperfect:  String
  lazy val thirdPersonPluralPluperfect    = rootVowel + "ram"

  // Future
  lazy val firstPersonSingularFuture  = rootVowel + "rei"
  lazy val secondPersonSingularFuture = rootVowel + "rás"
  lazy val thirdPersonSingularFuture  = rootVowel + "rá"
  lazy val firstPersonPluralFuture    = rootVowel + "remos"
  lazy val secondPersonPluralFuture   = rootVowel + "reis"
  lazy val thirdPersonPluralFuture    = rootVowel + "rão"

  // Conditional
  lazy val firstPersonSingularConditional  = rootVowel + "ria"
  lazy val secondPersonSingularConditional = rootVowel + "rias"
  lazy val thirdPersonSingularConditional  = rootVowel + "ria"
  lazy val firstPersonPluralConditional    = rootVowel + "ríamos"
  lazy val secondPersonPluralConditional   = rootVowel + "ríeis"
  lazy val thirdPersonPluralConditional    = rootVowel + "riam"

  // PresentSubjunctive
  lazy val firstPersonSingularPresentSubjunctive  = root + ???
  lazy val secondPersonSingularPresentSubjunctive = root + ???
  lazy val thirdPersonSingularPresentSubjunctive  = root + ???
  lazy val firstPersonPluralPresentSubjunctive    = root + ???
  lazy val secondPersonPluralPresentSubjunctive   = root + ???
  lazy val thirdPersonPluralPresentSubjunctive    = root + ???

  // ImperfectSubjunctive
  lazy val firstPersonSingularImperfectSubjunctive  = root + ???
  lazy val secondPersonSingularImperfectSubjunctive = root + ???
  lazy val thirdPersonSingularImperfectSubjunctive  = root + ???
  lazy val firstPersonPluralImperfectSubjunctive    = root + ???
  lazy val secondPersonPluralImperfectSubjunctive   = root + ???
  lazy val thirdPersonPluralImperfectSubjunctive    = root + ???

  // FutureSubjunctive
  lazy val firstPersonSingularFutureSubjunctive  = root + ???
  lazy val secondPersonSingularFutureSubjunctive = root + ???
  lazy val thirdPersonSingularFutureSubjunctive  = root + ???
  lazy val firstPersonPluralFutureSubjunctive    = root + ???
  lazy val secondPersonPluralFutureSubjunctive   = root + ???
  lazy val thirdPersonPluralFutureSubjunctive    = root + ???

  def print() = {
    println("\nGerund: " + gerund)

    for (t <- List(Present, Past, Imperfect)) {
      println("\n" + t.tense.capitalize + ":")

      for (n <- Numbers) {
        for (p <- Persons) {
          println(apply(t, p, n).word)
        }
      }
    }

    println("\nPluperfect:")
    println(firstPersonSingularPluperfect)
    println(secondPersonSingularPluperfect)
    println(thirdPersonSingularPluperfect)
    println(firstPersonPluralPluperfect)
    println(secondPersonPluralPluperfect)
    println(thirdPersonPluralPluperfect)

    println("\nFuture:")
    println(firstPersonSingularFuture)
    println(secondPersonSingularFuture)
    println(thirdPersonSingularFuture)
    println(firstPersonPluralFuture)
    println(secondPersonPluralFuture)
    println(thirdPersonPluralFuture)

    println("\nConditional:")
    println(firstPersonSingularConditional)
    println(secondPersonSingularConditional)
    println(thirdPersonSingularConditional)
    println(firstPersonPluralConditional)
    println(secondPersonPluralConditional)
    println(thirdPersonPluralConditional)
  }

  private def r(form: String) = InflectedForm(form, Regular)

  protected def s(form: String) = InflectedForm(form, SemiRegular)
}

class FirstConjugation(protected val root: String) extends Conjugation {
  val vowel = "a"

  val regularForms = veryRegularForms ++ Map(
    (Present, SecondPerson, Singular) -> s(root + "as"),
    (Present, ThirdPerson,  Singular) -> s(root + "a"),
    (Present, SecondPerson, Plural)   -> s(root + "ais"),
    (Present, ThirdPerson,  Plural)   -> s(root + "am"),

    (Past, FirstPerson, Singular) -> s(root + "ei"),
    (Past, ThirdPerson, Singular) -> s(root + "ou"),

    (Imperfect, FirstPerson,  Singular) -> s(root + "ava"),
    (Imperfect, SecondPerson, Singular) -> s(root + "avas"),
    (Imperfect, ThirdPerson,  Singular) -> s(root + "ava"),
    (Imperfect, FirstPerson,  Plural)   -> s(root + "ávamos"),
    (Imperfect, SecondPerson, Plural)   -> s(root + "áveis"),
    (Imperfect, ThirdPerson,  Plural)   -> s(root + "avam")
  )

  // Pluperfect
  lazy val firstPersonPluralPluperfect  = root + "áramos"
  lazy val secondPersonPluralPluperfect = root + "áreis"
}

class SecondConjugation(protected val root: String) extends Conjugation {
  val vowel = "e"

  val regularForms = veryRegularForms ++ Map(
    (Present, SecondPerson, Singular) -> s(root + "es"),
    (Present, ThirdPerson,  Singular) -> s(root + "e"),
    (Present, SecondPerson, Plural)   -> s(root + "eis"),
    (Present, ThirdPerson,  Plural)   -> s(root + "em"),

    (Past, FirstPerson, Singular) -> s(root + "i"),
    (Past, ThirdPerson, Singular) -> s(root + "eu"),

    (Imperfect, FirstPerson,  Singular) -> s(root + "ia"),
    (Imperfect, SecondPerson, Singular) -> s(root + "ias"),
    (Imperfect, ThirdPerson,  Singular) -> s(root + "ia"),
    (Imperfect, FirstPerson,  Plural)   -> s(root + "íamos"),
    (Imperfect, SecondPerson, Plural)   -> s(root + "íeis"),
    (Imperfect, ThirdPerson,  Plural)   -> s(root + "iam")
  )

  // Pluperfect
  lazy val firstPersonPluralPluperfect  = root + "êramos"
  lazy val secondPersonPluralPluperfect = root + "êreis"
}

class ThirdConjugation(protected val root: String) extends Conjugation {
  val vowel = "i"

  val regularForms = veryRegularForms ++ Map(
    (Present, SecondPerson, Singular) -> s(root + "es"),
    (Present, ThirdPerson,  Singular) -> s(root + "e"),
    (Present, SecondPerson, Plural)   -> s(root + "is"),
    (Present, ThirdPerson,  Plural)   -> s(root + "em"),

    (Past, FirstPerson, Singular) -> s(root + "i"),
    (Past, ThirdPerson, Singular) -> s(root + "iu"),

    (Imperfect, FirstPerson,  Singular) -> s(root + "ia"),
    (Imperfect, SecondPerson, Singular) -> s(root + "ias"),
    (Imperfect, ThirdPerson,  Singular) -> s(root + "ia"),
    (Imperfect, FirstPerson,  Plural)   -> s(root + "íamos"),
    (Imperfect, SecondPerson, Plural)   -> s(root + "íeis"),
    (Imperfect, ThirdPerson,  Plural)   -> s(root + "iam")
  )

  // Pluperfect
  lazy val firstPersonPluralPluperfect  = root + "íramos"
  lazy val secondPersonPluralPluperfect = root + "íreis"
}
