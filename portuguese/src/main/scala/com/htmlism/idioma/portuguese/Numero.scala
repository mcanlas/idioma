package com.htmlism.idioma.portuguese

sealed abstract class Number(val número: String)

object Singular extends Number("singular")
object Plural   extends Number("plural")
