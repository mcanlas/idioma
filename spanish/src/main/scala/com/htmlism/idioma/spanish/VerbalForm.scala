package com.htmlism.idioma.spanish

import scala.util.chaining._

import cats.data._
import cats.syntax.all._

enum VerbalForm:
  case Infinitive
  case PastParticiple
  case Gerund
  case PresentMood(person: GrammaticalPerson, number: GrammaticalNumber)

object VerbalForm:
  val personAndNumber: NonEmptyList[(GrammaticalPerson, GrammaticalNumber)] =
    val persons =
      GrammaticalPerson
        .values
        .toList
        .pipe(NonEmptyList.fromListUnsafe)

    val numbers =
      GrammaticalNumber
        .values
        .toList
        .pipe(NonEmptyList.fromListUnsafe)

    (numbers, persons)
      .tupled
      .map(_.swap)
