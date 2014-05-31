package com.htmlism.idioma

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

trait Conjugation {
  protected val root: String
  protected val vowel: String

  lazy val rootVowel = root + vowel

  // Present
  lazy val firstPersonSingularPresent   = root + "o"
       val secondPersonSingularPresent: String
       val thirdPersonSingularPresent:  String
  lazy val firstPersonPluralPresent     = rootVowel + "mos"
       val secondPersonPluralPresent:   String
       val thirdPersonPluralPresent:    String

  // Perfect
       val firstPersonSingularPerfect: String
  lazy val secondPersonSingularPerfect = rootVowel + "ste"
       val thirdPersonSingularPerfect: String
  lazy val firstPersonPluralPerfect    = rootVowel + "mos"
  lazy val secondPersonPluralPerfect   = rootVowel + "stes"
  lazy val thirdPersonPluralPerfect    = rootVowel + "ram"

  // Imperfect
       val firstPersonSingularImperfect:  String
       val secondPersonSingularImperfect: String
       val thirdPersonSingularImperfect:  String
       val firstPersonPluralImperfect:    String
       val secondPersonPluralImperfect:   String
       val thirdPersonPluralImperfect:    String

  // Pluperfect
  lazy val firstPersonSingularPluperfect  = root + ???
  lazy val secondPersonSingularPluperfect = root + ???
  lazy val thirdPersonSingularPluperfect  = root + ???
  lazy val firstPersonPluralPluperfect    = root + ???
  lazy val secondPersonPluralPluperfect   = root + ???
  lazy val thirdPersonPluralPluperfect    = root + ???

  // Future
  lazy val firstPersonSingularFuture  = root + ???
  lazy val secondPersonSingularFuture = root + ???
  lazy val thirdPersonSingularFuture  = root + ???
  lazy val firstPersonPluralFuture    = root + ???
  lazy val secondPersonPluralFuture   = root + ???
  lazy val thirdPersonPluralFuture    = root + ???

  // Conditional
  lazy val firstPersonSingularConditional  = root + ???
  lazy val secondPersonSingularConditional = root + ???
  lazy val thirdPersonSingularConditional  = root + ???
  lazy val firstPersonPluralConditional    = root + ???
  lazy val secondPersonPluralConditional   = root + ???
  lazy val thirdPersonPluralConditional    = root + ???

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
    println("\nPresent:")
    println(firstPersonSingularPresent)
    println(secondPersonSingularPresent)
    println(thirdPersonSingularPresent)
    println(firstPersonPluralPresent)
    println(secondPersonPluralPresent)
    println(thirdPersonPluralPresent)

    println("\nPerfect:")
    println(firstPersonSingularPerfect)
    println(secondPersonSingularPerfect)
    println(thirdPersonSingularPerfect)
    println(firstPersonPluralPerfect)
    println(secondPersonPluralPerfect)
    println(thirdPersonPluralPerfect)

    println("\nImperfect:")
    println(firstPersonSingularImperfect)
    println(secondPersonSingularImperfect)
    println(thirdPersonSingularImperfect)
    println(firstPersonPluralImperfect)
    println(secondPersonPluralImperfect)
    println(thirdPersonPluralImperfect)
  }
}

class FirstConjugation(protected val root: String) extends Conjugation {
  val vowel = "a"

  // Present
  lazy val secondPersonSingularPresent = root + "as"
  lazy val thirdPersonSingularPresent  = root + "a"
  lazy val secondPersonPluralPresent   = root + "ais"
  lazy val thirdPersonPluralPresent    = root + "am"

  // Perfect
  lazy val firstPersonSingularPerfect = root + "ei"
  lazy val thirdPersonSingularPerfect = root + "ou"

  // Imperfect
  lazy val firstPersonSingularImperfect  = root + "ava"
  lazy val secondPersonSingularImperfect = root + "avas"
  lazy val thirdPersonSingularImperfect  = root + "ava"
  lazy val firstPersonPluralImperfect    = root + "ávamos"
  lazy val secondPersonPluralImperfect   = root + "áveis"
  lazy val thirdPersonPluralImperfect    = root + "avam"
}

class SecondConjugation(protected val root: String) extends Conjugation {
  val vowel = "e"

  // Present
  lazy val secondPersonSingularPresent = root + "es"
  lazy val thirdPersonSingularPresent  = root + "e"
  lazy val secondPersonPluralPresent   = root + "eis"
  lazy val thirdPersonPluralPresent    = root + "em"

  // Perfect
  lazy val firstPersonSingularPerfect = root + "i"
  lazy val thirdPersonSingularPerfect = root + "eu"

  // Imperfect
  lazy val firstPersonSingularImperfect  = root + "ia"
  lazy val secondPersonSingularImperfect = root + "ias"
  lazy val thirdPersonSingularImperfect  = root + "ia"
  lazy val firstPersonPluralImperfect    = root + "íamos"
  lazy val secondPersonPluralImperfect   = root + "íeis"
  lazy val thirdPersonPluralImperfect    = root + "iam"
}

class ThirdConjugation(protected val root: String) extends Conjugation {
  val vowel = "i"

  // Present
  lazy val secondPersonSingularPresent = root + "es"
  lazy val thirdPersonSingularPresent  = root + "e"
  lazy val secondPersonPluralPresent   = root + "is"
  lazy val thirdPersonPluralPresent    = root + "em"

  // Perfect
  lazy val firstPersonSingularPerfect = root + "i"
  lazy val thirdPersonSingularPerfect = root + "iu"

  // Imperfect
  lazy val firstPersonSingularImperfect  = root + "ia"
  lazy val secondPersonSingularImperfect = root + "ias"
  lazy val thirdPersonSingularImperfect  = root + "ia"
  lazy val firstPersonPluralImperfect    = root + "íamos"
  lazy val secondPersonPluralImperfect   = root + "íeis"
  lazy val thirdPersonPluralImperfect    = root + "iam"
}
