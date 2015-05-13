package com.htmlism.idioma.portuguese

import org.json4s.JsonAST.{ JNothing, JValue, JString, JObject }
import CategoriasGramaticais._

object Verb {
  def apply(jv: JValue): Verb = jv match {
    case JObject(fields) =>
      val map = fields.toMap

      val JString(infinitive) = map("infinitive")

      val conjugation = Conjugação(infinitive).getOrElse(throw new RuntimeException(s"could not conjugate infinitive $infinitive"))

      val forms = List(Presente, Perfeito, Imperfeito).flatMap { t =>
        Pessoas.flatMap { p =>
          Números.map { n =>
            val maybeIrregularForm = jv \ t.tempo \ (p.pessoa + n.número.capitalize)

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

case class Verb(infinitive: String, gerund: String, private val forms: Map[(Tempo, Pessoa, Número), InflectedForm]) extends CanConjugate {
  def apply(tense: Tempo, person: Pessoa, number: Número) = forms((tense, person, number))
}
