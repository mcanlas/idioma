package com.htmlism.idioma

trait Conjugation {
  protected val root: String
  protected val vowel: String
  protected val rootVowel = root + vowel

  val secondPersonSingularPresentSuffix: String
  val thirdPersonSingularPresentSuffix:  String
  val secondPersonPluralPresentSuffix:   String
  val thirdPersonPluralPresentSuffix:    String

  // Present
  val firstPersonSingularPresent  = root + "o"
  val secondPersonSingularPresent = root + secondPersonSingularPresentSuffix
  val thirdPersonSingularPresent  = root + thirdPersonSingularPresentSuffix
  val firstPersonPluralPresent    = rootVowel + "mos"
  val secondPersonPluralPresent   = root + secondPersonPluralPresentSuffix
  val thirdPersonPluralPresent    = root + thirdPersonPluralPresentSuffix

  // Perfect
  lazy val firstPersonSingularPerfect  = root + ???
  lazy val secondPersonSingularPerfect = root + ???
  lazy val thirdPersonSingularPerfect  = root + ???
  lazy val firstPersonPluralPerfect    = root + ???
  lazy val secondPersonPluralPerfect   = root + ???
  lazy val thirdPersonPluralPerfect    = root + ???

  // Imperfect
  lazy val firstPersonSingularImperfect  = root + ???
  lazy val secondPersonSingularImperfect = root + ???
  lazy val thirdPersonSingularImperfect  = root + ???
  lazy val firstPersonPluralImperfect    = root + ???
  lazy val secondPersonPluralImperfect   = root + ???
  lazy val thirdPersonPluralImperfect    = root + ???

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
}

class FirstConjugation(protected val root: String) extends Conjugation {
  val vowel = "a"

  val secondPersonSingularPresentSuffix = "as"
  val thirdPersonSingularPresentSuffix  = "a"
  val secondPersonPluralPresentSuffix   = "ais"
  val thirdPersonPluralPresentSuffix    = "am"
}

class SecondConjugation(protected val root: String) extends Conjugation {
  val vowel = "e"

  val secondPersonSingularPresentSuffix = "es"
  val thirdPersonSingularPresentSuffix  = "e"
  val secondPersonPluralPresentSuffix   = "eis"
  val thirdPersonPluralPresentSuffix    = "em"
}

class ThirdConjugation(protected val root: String) extends Conjugation {
  val vowel = "i"

  val secondPersonSingularPresentSuffix = "es"
  val thirdPersonSingularPresentSuffix  = "e"
  val secondPersonPluralPresentSuffix   = "is"
  val thirdPersonPluralPresentSuffix    = "em"
}
