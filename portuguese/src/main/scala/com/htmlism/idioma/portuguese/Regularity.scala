package com.htmlism.idioma.portuguese

sealed trait Regularity

case object Regular extends Regularity
case object SemiRegular extends Regularity
case object Irregular extends Regularity
