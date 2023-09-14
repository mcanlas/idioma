package com.htmlism.idioma.portuguese

object CategoriasGramaticais:
  val Definitivo   = Especificação("definite", "d")
  val Indefinitivo = Especificação("indefinite", "i")

  val Tempos = List(
    Presente,
    Perfeito,
    Imperfeito,
    MasQuePerfeito,
    Futuro,
    Condicional,
    SubjuntivoDoPresente,
    SubjuntivoDoImperfeito,
    SubjuntivoDoFuturo
  )
  val Pessoas = List(PessoaPrimeira, PessoaSegunda, PessoaTerceira)
  val Numeros = List(Singular, Plural)

  val Pronomes = Map(
    (Singular, PessoaPrimeira) -> List("eu"),
    (Singular, PessoaSegunda)  -> List("tu"),
    (Singular, PessoaTerceira) -> List("ele", "ela", "gente"),
    (Plural, PessoaPrimeira)   -> List("nós"),
    (Plural, PessoaSegunda)    -> List("vós"),
    (Plural, PessoaTerceira)   -> List("eles", "elas")
  )

case class Especificação(especificação: String, código: String)
