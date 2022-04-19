package com.htmlism.idioma.portuguese

object Number {
  lazy val lookup = CategoriasGramaticais
    .Numeros
    .map { n =>
      n.número -> n
    }
    .toMap

  def apply(s: String) = lookup(s)
}

sealed abstract class Number(val número: String)

object Singular extends Number("singular")
object Plural extends Number("plural")
