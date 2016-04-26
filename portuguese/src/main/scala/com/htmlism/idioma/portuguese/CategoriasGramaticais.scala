package com.htmlism.idioma.portuguese

object CategoriasGramaticais {
  val Singular  = Número("singular", "S")
  val Plural    = Número("plural",   "P")

  val Masculino = Gênero("masculine", "m")
  val Feminino  = Gênero("feminine",  "f")
  val Ambos     = Gênero("either",    "mf")

  val Definitivo   = Especificação("definite",   "d")
  val Indefinitivo = Especificação("indefinite", "i")

  val Tempos  = List(Presente, Perfeito, Imperfeito, MasQuePerfeito, Futuro, Condicional, SubjuntivoDoPresente, SubjuntivoDoImperfeito, SubjuntivoDoFuturo)
  val Pessoas = List(PessoaPrimeira, PessoaSegunda, PessoaTerceira)
  val Números = List(Singular, Plural)
  val Gêneros = List(Masculino, Feminino, Ambos)

  val Pronomes = Map(
    (Singular, PessoaPrimeira) -> Seq("eu"),
    (Singular, PessoaSegunda)  -> Seq("tu"),
    (Singular, PessoaTerceira) -> Seq("ele", "ela", "gente"),
    (Plural, PessoaPrimeira)   -> Seq("nós"),
    (Plural, PessoaSegunda)    -> Seq("vós"),
    (Plural, PessoaTerceira)   -> Seq("eles", "elas"))
}

case class Número(número: String, código: String)

case class Gênero(gênero: String, código: String)

case class Especificação(especificação: String, código: String)
