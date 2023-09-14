package com.htmlism.idioma.spanish

import cats.syntax.all._

enum VerbConjugation:
  case Ar
  case Er
  case Ir

object VerbConjugation:
  def unapply(s: String): Option[VerbConjugation] =
    s match
      case "ar" => Ar.some
      case "er" => Er.some
      case "ir" => Ir.some
      case _    => None
