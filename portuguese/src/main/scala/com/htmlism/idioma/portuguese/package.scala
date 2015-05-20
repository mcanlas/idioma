package com.htmlism.idioma

import scala.language.implicitConversions

package object portuguese {
  implicit def conjugationToPrinter(conjugação: Conjugação): ConjugationPrinter = new ConjugationPrinter(conjugação)
}
