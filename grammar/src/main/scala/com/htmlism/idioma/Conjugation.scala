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
  val firstPersonSingularPerfect  = root + ???
  val secondPersonSingularPerfect = root + ???
  val thirdPersonSingularPerfect  = root + ???
  val firstPersonPluralPerfect    = root + ???
  val secondPersonPluralPerfect   = root + ???
  val thirdPersonPluralPerfect    = root + ???

  // Imperfect
  val firstPersonSingularImperfect  = root + ???
  val secondPersonSingularImperfect = root + ???
  val thirdPersonSingularImperfect  = root + ???
  val firstPersonPluralImperfect    = root + ???
  val secondPersonPluralImperfect   = root + ???
  val thirdPersonPluralImperfect    = root + ???

  // Pluperfect
  val firstPersonSingularPluperfect  = root + ???
  val secondPersonSingularPluperfect = root + ???
  val thirdPersonSingularPluperfect  = root + ???
  val firstPersonPluralPluperfect    = root + ???
  val secondPersonPluralPluperfect   = root + ???
  val thirdPersonPluralPluperfect    = root + ???

  // Future
  val firstPersonSingularFuture  = root + ???
  val secondPersonSingularFuture = root + ???
  val thirdPersonSingularFuture  = root + ???
  val firstPersonPluralFuture    = root + ???
  val secondPersonPluralFuture   = root + ???
  val thirdPersonPluralFuture    = root + ???

  // Conditional
  val firstPersonSingularConditional  = root + ???
  val secondPersonSingularConditional = root + ???
  val thirdPersonSingularConditional  = root + ???
  val firstPersonPluralConditional    = root + ???
  val secondPersonPluralConditional   = root + ???
  val thirdPersonPluralConditional    = root + ???

  // PresentSubjunctive
  val firstPersonSingularPresentSubjunctive  = root + ???
  val secondPersonSingularPresentSubjunctive = root + ???
  val thirdPersonSingularPresentSubjunctive  = root + ???
  val firstPersonPluralPresentSubjunctive    = root + ???
  val secondPersonPluralPresentSubjunctive   = root + ???
  val thirdPersonPluralPresentSubjunctive    = root + ???

  // ImperfectSubjunctive
  val firstPersonSingularImperfectSubjunctive  = root + ???
  val secondPersonSingularImperfectSubjunctive = root + ???
  val thirdPersonSingularImperfectSubjunctive  = root + ???
  val firstPersonPluralImperfectSubjunctive    = root + ???
  val secondPersonPluralImperfectSubjunctive   = root + ???
  val thirdPersonPluralImperfectSubjunctive    = root + ???

  // FutureSubjunctive
  val firstPersonSingularFutureSubjunctive  = root + ???
  val secondPersonSingularFutureSubjunctive = root + ???
  val thirdPersonSingularFutureSubjunctive  = root + ???
  val firstPersonPluralFutureSubjunctive    = root + ???
  val secondPersonPluralFutureSubjunctive   = root + ???
  val thirdPersonPluralFutureSubjunctive    = root + ???
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
