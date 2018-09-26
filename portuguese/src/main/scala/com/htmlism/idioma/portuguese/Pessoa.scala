package com.htmlism.idioma.portuguese

object Pessoa {
  lazy val lookup = CategoriasGramaticais.Pessoas.map { p =>
    p.pessoa -> p
  }.toMap

  def apply(s: String) = lookup(s)
}

sealed abstract class Pessoa(val pessoa: String)

object PessoaPrimeira extends Pessoa("first")
object PessoaSegunda  extends Pessoa("second")
object PessoaTerceira extends Pessoa("third")
