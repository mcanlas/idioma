package com.htmlism.idioma.portuguese

sealed abstract class Número(val número: String)

object Singular extends Número("singular")
object Plural   extends Número("plural")
