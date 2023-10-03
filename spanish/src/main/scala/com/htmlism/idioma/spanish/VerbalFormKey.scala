package com.htmlism.idioma.spanish

import scala.util.chaining.*

import cats.data.*
import cats.syntax.all.*

enum VerbalFormKey:
  case Infinitive
  case PastParticiple
  case Gerund
  case PresentMood(tense: GrammaticalTense, number: GrammaticalNumber, person: GrammaticalPerson)

object VerbalFormKey:
  val matrix: NonEmptyList[(GrammaticalTense, GrammaticalNumber, GrammaticalPerson)] =
    val tenses =
      GrammaticalTense
        .values
        .toList
        .pipe(NonEmptyList.fromListUnsafe)

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

    (tenses, numbers, persons).tupled
