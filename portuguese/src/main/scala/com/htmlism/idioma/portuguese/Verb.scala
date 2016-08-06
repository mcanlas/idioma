package com.htmlism.idioma.portuguese

import org.json4s.JsonAST.{ JNothing, JValue, JString, JObject }
import CategoriasGramaticais._

object OldVerb {
  def apply(jv: JValue): OldVerb = jv match {
    case JObject(fields) =>
      val map = fields.toMap

      val JString(infinitive) = map("infinitive")

      val conjugation = Conjugação(infinitive).getOrElse(throw new RuntimeException(s"could not conjugate infinitive $infinitive"))

      val forms = List(Presente, Perfeito, Imperfeito).flatMap { t =>
        Pessoas.flatMap { p =>
          Números.map { n =>
            val maybeIrregularForm = jv \ t.key \ (p.pessoa + n.número.capitalize)

            val form = maybeIrregularForm match {
              case JString(s) => IrregularForm(s)
              case JNothing   => conjugation(t, p, n)
              case _          => throw new RuntimeException(s"unexpected jvalue instance $maybeIrregularForm")
            }

            ((t, p, n), form)
          }
        }
      }

      val gerund = conjugation.gerund

      new OldVerb(infinitive, gerund, forms.toMap)
    case _ => throw new IllegalArgumentException("OldVerb constructor needs a jObject")
  }
}

case class OldVerb(infinitive: String, gerund: String, private val forms: Map[(Tempo, Pessoa, Número), InflectedForm]) extends CanConjugate {
  def apply(tense: Tempo, person: Pessoa, number: Número): InflectedForm = forms((tense, person, number))
}
