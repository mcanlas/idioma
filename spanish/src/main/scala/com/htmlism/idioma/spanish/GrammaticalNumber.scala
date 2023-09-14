package com.htmlism.idioma.spanish

enum GrammaticalNumber(val s: String):
  case Singular extends GrammaticalNumber("singular")
  case Plural   extends GrammaticalNumber("plural")
