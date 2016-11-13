package com.htmlism.idioma.portuguese

object Number {
  def apply = CategoriasGramaticais
    .Numeros
    .map { n => n.número -> n }
    .toMap: String => Number
}

sealed abstract class Number(val número: String)

object Singular extends Number("singular")
object Plural   extends Number("plural")
