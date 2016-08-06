package com.htmlism.idioma.portuguese

object Conjugação {
  private val RootPattern = "(.*)([aeiô])r".r

  def apply(infinitive: String): Option[Conjugação] = infinitive match {
    case RootPattern(root, vowel) =>
      val conjugação = vowel match {
        case "a" => new ConjugaçãoPrimeira(root)
        case "e" => new ConjugaçãoSegunda(root)
        case "i" => new ConjugaçãoTerceira(root)
        case "ô" => new ConjugaçãoQuarta(root)
      }

      Some(conjugação)
    case _ => None
  }
}

trait Conjugação extends CanConjugate {
  protected def root: String
  protected def vowel: String
  protected def regularForms: Map[(Tempo, Pessoa, Número), InflectedForm]

  def apply(tense: Tempo, person: Pessoa, number: Número): InflectedForm = regularForms((tense, person, number))

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
  protected def firstPersonPluralPluperfect:  String
  protected def secondPersonPluralPluperfect: String
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

  private def r(form: String) = RegularForm(form)

  protected def s(form: String) = ConjugationForm(form)
}

case class ConjugaçãoPrimeira(root: String) extends Conjugação {
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
  protected lazy val firstPersonPluralPluperfect  = root + "áramos"
  protected lazy val secondPersonPluralPluperfect = root + "áreis"
}

case class ConjugaçãoSegunda(root: String) extends Conjugação {
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
  protected lazy val firstPersonPluralPluperfect  = root + "êramos"
  protected lazy val secondPersonPluralPluperfect = root + "êreis"
}

case class ConjugaçãoTerceira(root: String) extends Conjugação {
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
  protected lazy val firstPersonPluralPluperfect  = root + "íramos"
  protected lazy val secondPersonPluralPluperfect = root + "íreis"
}

case class ConjugaçãoQuarta(root: String) extends Conjugação {
  protected def vowel = "o"

  protected def regularForms = veryRegularForms

  protected lazy val secondPersonPluralPluperfect: String = ???
  protected lazy val firstPersonPluralPluperfect: String = ???
}

trait Conjugation {
  def vowel: String

  def gerund(root: String): InflectedForm = RegularForm(root + vowel + "ndo")

  def pastParticiple(root: String): InflectedForm

  def apply(root: String, tense: Tempo, person: Pessoa, number: Número): InflectedForm
}

object FirstConjugation extends Conjugation {
  val vowel: String = "a"

  def pastParticiple(root: String) = RegularForm(root + "ado")

  def apply(root: String, tense: Tempo, person: Pessoa, number: Número) = ???
}

object SecondConjugation extends Conjugation {
  val vowel = "e"

  def pastParticiple(root: String) = RegularForm(root + "ido")

  def apply(root: String, tense: Tempo, person: Pessoa, number: Número) = ???
}

object ThirdConjugation extends Conjugation {
  val vowel = "i"

  def pastParticiple(root: String) = RegularForm(root + "ido")

  def apply(root: String, tense: Tempo, person: Pessoa, number: Número) = ???
}
