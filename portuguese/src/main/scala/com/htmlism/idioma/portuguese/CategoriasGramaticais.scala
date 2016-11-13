package com.htmlism.idioma.portuguese

object CategoriasGramaticais {
  val Definitivo   = Especificação("definite",   "d")
  val Indefinitivo = Especificação("indefinite", "i")

  val Tempos  = Seq(Presente, Perfeito, Imperfeito, MasQuePerfeito, Futuro, Condicional, SubjuntivoDoPresente, SubjuntivoDoImperfeito, SubjuntivoDoFuturo)
  val Pessoas = Seq(PessoaPrimeira, PessoaSegunda, PessoaTerceira)
  val Numeros = Seq(Singular, Plural)
  val Generos = Seq(Masculino, Feminino, Ambos)

  val Pronomes = Map(
    (Singular, PessoaPrimeira) -> Seq("eu"),
    (Singular, PessoaSegunda)  -> Seq("tu"),
    (Singular, PessoaTerceira) -> Seq("ele", "ela", "gente"),
    (Plural, PessoaPrimeira)   -> Seq("nós"),
    (Plural, PessoaSegunda)    -> Seq("vós"),
    (Plural, PessoaTerceira)   -> Seq("eles", "elas"))
}

case class Especificação(especificação: String, código: String)
