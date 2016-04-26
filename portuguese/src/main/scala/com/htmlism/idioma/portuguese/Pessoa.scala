package com.htmlism.idioma.portuguese

sealed abstract class Pessoa(val pessoa: String)

object PessoaPrimeira extends Pessoa("first")
object PessoaSegunda  extends Pessoa("second")
object PessoaTerceira extends Pessoa("third")

