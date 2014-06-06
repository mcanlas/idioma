package com.htmlism.idioma.portuguese

import com.htmlism.idioma.portuguese.GrammaticalCategories._

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

  lazy val veryRegularForms = Map(
    (Present, FirstPerson, Singular) -> r(root + "o"),
    (Present, FirstPerson, Plural)   -> r(rootVowel + "mos"),

    (Perfect, SecondPerson, Singular) -> r(rootVowel + "ste"),
    (Perfect, FirstPerson, Plural)    -> r(rootVowel + "mos"),
    (Perfect, SecondPerson, Plural)   -> r(rootVowel + "stes"),
    (Perfect, ThirdPerson, Plural)    -> r(rootVowel + "ram")
  )

  // Imperfect
       val firstPersonSingularImperfect:  String
       val secondPersonSingularImperfect: String
       val thirdPersonSingularImperfect:  String
       val firstPersonPluralImperfect:    String
       val secondPersonPluralImperfect:   String
       val thirdPersonPluralImperfect:    String

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
    println("\nImperfect:")
    println(firstPersonSingularImperfect)
    println(secondPersonSingularImperfect)
    println(thirdPersonSingularImperfect)
    println(firstPersonPluralImperfect)
    println(secondPersonPluralImperfect)
    println(thirdPersonPluralImperfect)

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

    (Perfect, FirstPerson, Singular) -> s(root + "ei"),
    (Perfect, ThirdPerson, Singular) -> s(root + "ou")
  )

  // Imperfect
  lazy val firstPersonSingularImperfect  = root + "ava"
  lazy val secondPersonSingularImperfect = root + "avas"
  lazy val thirdPersonSingularImperfect  = root + "ava"
  lazy val firstPersonPluralImperfect    = root + "ávamos"
  lazy val secondPersonPluralImperfect   = root + "áveis"
  lazy val thirdPersonPluralImperfect    = root + "avam"

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

    (Perfect, FirstPerson, Singular) -> s(root + "i"),
    (Perfect, ThirdPerson, Singular) -> s(root + "eu")
  )

  // Imperfect
  lazy val firstPersonSingularImperfect  = root + "ia"
  lazy val secondPersonSingularImperfect = root + "ias"
  lazy val thirdPersonSingularImperfect  = root + "ia"
  lazy val firstPersonPluralImperfect    = root + "íamos"
  lazy val secondPersonPluralImperfect   = root + "íeis"
  lazy val thirdPersonPluralImperfect    = root + "iam"

  // Pluperfect
  lazy val firstPersonPluralPluperfect  = root + "êramos"
  lazy val secondPersonPluralPluperfect = root + "êreis"
}

class ThirdConjugation(protected val root: String) extends Conjugation {
  val vowel = "i"

  val regularForms = veryRegularForms ++ Map(
    (Present, SecondPerson, Singular) -> s(root + "es"),
    (Present, ThirdPerson, Singular)  -> s(root + "e"),
    (Present, SecondPerson, Plural)   -> s(root + "is"),
    (Present, ThirdPerson, Plural)    -> s(root + "em"),

    (Perfect, FirstPerson, Singular) -> s(root + "i"),
    (Perfect, ThirdPerson, Singular) -> s(root + "iu")
  )

  // Imperfect
  lazy val firstPersonSingularImperfect  = root + "ia"
  lazy val secondPersonSingularImperfect = root + "ias"
  lazy val thirdPersonSingularImperfect  = root + "ia"
  lazy val firstPersonPluralImperfect    = root + "íamos"
  lazy val secondPersonPluralImperfect   = root + "íeis"
  lazy val thirdPersonPluralImperfect    = root + "iam"

  // Pluperfect
  lazy val firstPersonPluralPluperfect  = root + "íramos"
  lazy val secondPersonPluralPluperfect = root + "íreis"
}
