package com.htmlism.idioma.portuguese

object Pessoa {
  def apply = CategoriasGramaticais
    .Pessoas
    .map { p => p.pessoa -> p }
    .toMap: String => Pessoa
}

sealed abstract class Pessoa(val pessoa: String)

object PessoaPrimeira extends Pessoa("first")
object PessoaSegunda  extends Pessoa("second")
object PessoaTerceira extends Pessoa("third")

