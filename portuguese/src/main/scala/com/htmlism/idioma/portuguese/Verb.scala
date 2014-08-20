package com.htmlism.idioma.portuguese

import org.json4s.JsonAST.{ JNothing, JValue, JString, JObject }
import CategoriasGramaticais._

object Verb {
  def apply(jv: JValue): Verb = jv match {
    case JObject(fields) =>
      val map = fields.toMap

      val JString(infinitive) = map("infinitive")

      val conjugation = Conjugation(infinitive)

      val forms = List(Present, Past, Imperfect).flatMap { t =>
        Persons.flatMap { p =>
          Numbers.map { n =>
            val maybeIrregularForm = jv \ t.tempo \ (p.person + n.number.capitalize)

            val form = maybeIrregularForm match {
              case JString(s) => InflectedForm(s, Irregular)
              case JNothing   => conjugation(t, p, n)
              case _          => throw new RuntimeException(s"unexpected jvalue instance $maybeIrregularForm")
            }

            ((t, p, n), form)
          }
        }
      }

      val gerund = conjugation.gerund

      new Verb(infinitive, gerund, forms.toMap)
    case _ => throw new IllegalArgumentException("verb constructor needs a jObject")
  }
}

case class Verb(infinitive: String, gerund: String, private val forms: Map[(Tense, Person, Number), InflectedForm]) extends CanConjugate {
  def apply(tense: Tense, person: Person, number: Number) = forms((tense, person, number))
}
