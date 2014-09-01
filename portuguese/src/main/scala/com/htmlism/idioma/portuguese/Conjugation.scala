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
  protected val regularForms: Map[(Tempo, Pessoa, Número), InflectedForm]

  def apply(tense: Tempo, person: Pessoa, number: Número) = regularForms((tense, person, number))

  lazy val rootVowel = root + vowel

  lazy val gerund = rootVowel + "ndo"

  lazy val veryRegularForms = Map(
    (Presente, PessoaPrimeira, Singular) -> r(root + "o"),
    (Presente, PessoaPrimeira, Plural)   -> r(rootVowel + "mos"),

    (Perfeito, PessoaSegunda,  Singular) -> r(rootVowel + "ste"),
    (Perfeito, PessoaPrimeira, Plural)   -> r(rootVowel + "mos"),
    (Perfeito, PessoaSegunda,  Plural)   -> r(rootVowel + "stes"),
    (Perfeito, PessoaTerceira, Plural)   -> r(rootVowel + "ram")
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

    for (t <- List(Presente, Perfeito, Imperfeito)) {
      println("\n" + t.tempo.capitalize + ":")

      for (n <- Números) {
        for (p <- Pessoas) {
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
    (Presente, PessoaSegunda,  Singular) -> s(root + "as"),
    (Presente, PessoaTerceira, Singular) -> s(root + "a"),
    (Presente, PessoaSegunda,  Plural)   -> s(root + "ais"),
    (Presente, PessoaTerceira, Plural)   -> s(root + "am"),

    (Perfeito, PessoaPrimeira, Singular) -> s(root + "ei"),
    (Perfeito, PessoaTerceira, Singular) -> s(root + "ou"),

    (Imperfeito, PessoaPrimeira, Singular) -> s(root + "ava"),
    (Imperfeito, PessoaSegunda,  Singular) -> s(root + "avas"),
    (Imperfeito, PessoaTerceira, Singular) -> s(root + "ava"),
    (Imperfeito, PessoaPrimeira, Plural)   -> s(root + "ávamos"),
    (Imperfeito, PessoaSegunda,  Plural)   -> s(root + "áveis"),
    (Imperfeito, PessoaTerceira, Plural)   -> s(root + "avam")
  )

  // Pluperfect
  lazy val firstPersonPluralPluperfect  = root + "áramos"
  lazy val secondPersonPluralPluperfect = root + "áreis"
}

class SecondConjugation(protected val root: String) extends Conjugation {
  val vowel = "e"

  val regularForms = veryRegularForms ++ Map(
    (Presente, PessoaSegunda,  Singular) -> s(root + "es"),
    (Presente, PessoaTerceira, Singular) -> s(root + "e"),
    (Presente, PessoaSegunda,  Plural)   -> s(root + "eis"),
    (Presente, PessoaTerceira, Plural)   -> s(root + "em"),

    (Perfeito, PessoaPrimeira, Singular) -> s(root + "i"),
    (Perfeito, PessoaTerceira, Singular) -> s(root + "eu"),

    (Imperfeito, PessoaPrimeira, Singular) -> s(root + "ia"),
    (Imperfeito, PessoaSegunda,  Singular) -> s(root + "ias"),
    (Imperfeito, PessoaTerceira, Singular) -> s(root + "ia"),
    (Imperfeito, PessoaPrimeira, Plural)   -> s(root + "íamos"),
    (Imperfeito, PessoaSegunda,  Plural)   -> s(root + "íeis"),
    (Imperfeito, PessoaTerceira, Plural)   -> s(root + "iam")
  )

  // Pluperfect
  lazy val firstPersonPluralPluperfect  = root + "êramos"
  lazy val secondPersonPluralPluperfect = root + "êreis"
}

class ThirdConjugation(protected val root: String) extends Conjugation {
  val vowel = "i"

  val regularForms = veryRegularForms ++ Map(
    (Presente, PessoaSegunda,  Singular) -> s(root + "es"),
    (Presente, PessoaTerceira, Singular) -> s(root + "e"),
    (Presente, PessoaSegunda,  Plural)   -> s(root + "is"),
    (Presente, PessoaTerceira, Plural)   -> s(root + "em"),

    (Perfeito, PessoaPrimeira, Singular) -> s(root + "i"),
    (Perfeito, PessoaTerceira, Singular) -> s(root + "iu"),

    (Imperfeito, PessoaPrimeira, Singular) -> s(root + "ia"),
    (Imperfeito, PessoaSegunda,  Singular) -> s(root + "ias"),
    (Imperfeito, PessoaTerceira, Singular) -> s(root + "ia"),
    (Imperfeito, PessoaPrimeira, Plural)   -> s(root + "íamos"),
    (Imperfeito, PessoaSegunda,  Plural)   -> s(root + "íeis"),
    (Imperfeito, PessoaTerceira, Plural)   -> s(root + "iam")
  )

  // Pluperfect
  lazy val firstPersonPluralPluperfect  = root + "íramos"
  lazy val secondPersonPluralPluperfect = root + "íreis"
}
