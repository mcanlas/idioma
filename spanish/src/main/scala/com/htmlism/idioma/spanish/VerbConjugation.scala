package com.htmlism.idioma.spanish

import cats.syntax.all._

enum VerbConjugation(val vowel: String):
  case Ar extends VerbConjugation("a")
  case Er extends VerbConjugation("e")
  case Ir extends VerbConjugation("i")

object VerbConjugation:
  def unapply(s: String): Option[VerbConjugation] =
    s match
      case "a" => Ar.some
      case "e" => Er.some
      case "i" => Ir.some
      case _   => None
