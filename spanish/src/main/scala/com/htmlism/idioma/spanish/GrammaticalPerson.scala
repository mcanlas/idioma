package com.htmlism.idioma.spanish

enum GrammaticalPerson(val s: String):
  case FirstPerson  extends GrammaticalPerson("first")
  case SecondPerson extends GrammaticalPerson("second")
  case ThirdPerson  extends GrammaticalPerson("third")
