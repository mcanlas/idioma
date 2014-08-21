package com.htmlism.idioma.portuguese

object CategoriasGramaticais {
  val Presente        = Tempo("present",     "PRS")
  val Perfeito        = Tempo("perfect",     "PST")
  val Imperfeito      = Tempo("imperfect",   "IMP")
  val MasQuePerfeito  = Tempo("pluperfect",  "PLU")
  val Futuro          = Tempo("future",      "FUT")
  val Condicional     = Tempo("conditional", "CND")

  val SubjuntivoDoPresente   = Tempo("presentSubjunctive",   "PRSSUB")
  val SubjuntivoDoImperfeito = Tempo("imperfectSubjunctive", "IMPSUB")
  val SubjuntivoDoFuturo     = Tempo("futureSubjunctive",    "FUTSUB")

  val PessoaPrimeira  = Pessoa("first",  "1")
  val PessoaSegunda   = Pessoa("second", "2")
  val PessoaTerceira  = Pessoa("third",  "3")

  val Singular  = Número("singular", "S")
  val Plural    = Número("plural",   "P")

  val Masculine = Gênero("masculine", "m")
  val Feminine  = Gênero("feminine",  "f")
  val Either    = Gênero("either",    "mf")

  val Definite   = Especificação("definite",   "d")
  val Indefinite = Especificação("indefinite", "i")

  val Tenses  = List(Presente, Perfeito, Imperfeito, MasQuePerfeito, Futuro, Condicional, SubjuntivoDoPresente, SubjuntivoDoImperfeito, SubjuntivoDoFuturo)
  val Persons = List(PessoaPrimeira, PessoaSegunda, PessoaTerceira)
  val Numbers = List(Singular, Plural)
  val Genders = List(Masculine, Feminine, Either)
}

case class Tempo(tempo: String, código: String)

case class Pessoa(pessoa: String, código: String)

case class Número(número: String, código: String)

case class Gênero(gênero: String, código: String)

case class Especificação(especificação: String, código: String)
