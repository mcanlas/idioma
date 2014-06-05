package com.htmlism.idioma.portuguese

import org.json4s.JsonAST.{ JValue, JString, JObject }
import GrammaticalCategories.Numbers

object Verb {
  def apply(jv: JValue): Verb = jv match {
    case JObject(fields) =>
      val map = fields.toMap

      val JString(infinitive) = map("infinitive")

      val conjugation = Conjugation(infinitive)
      println(conjugation)

      val forms = List(GrammaticalCategories.Present).flatMap { case t =>
        List(GrammaticalCategories.FirstPerson).flatMap { case p =>
          Numbers.map { case n =>
            ((t, p, n), conjugation(t, p, n))
          }
        }
      }

      new Verb(forms.toMap)
    case _ => throw new IllegalArgumentException("verb constructor needs a jObject")
  }
}

case class Verb(private val forms: Map[(Tense, Person, Number), InflectedForm]) extends CanConjugate {
  def apply(tense: Tense, person: Person, number: Number) = forms((tense, person, number))
}
