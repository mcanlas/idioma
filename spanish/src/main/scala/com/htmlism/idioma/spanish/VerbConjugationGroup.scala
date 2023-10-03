package com.htmlism.idioma.spanish

import cats.syntax.all.*

enum VerbConjugationGroup(val vowel: String):
  case Ar extends VerbConjugationGroup("a")
  case Er extends VerbConjugationGroup("e")
  case Ir extends VerbConjugationGroup("i")

object VerbConjugationGroup:
  def unapply(s: String): Option[VerbConjugationGroup] =
    s match
      case "a" => Ar.some
      case "e" => Er.some
      case "i" => Ir.some
      case _   => None
