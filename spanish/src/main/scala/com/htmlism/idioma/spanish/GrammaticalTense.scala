package com.htmlism.idioma.spanish

enum GrammaticalTense(val s: String):
  case Present   extends GrammaticalTense("present")
  case Preterite extends GrammaticalTense("preterite")
