package com.htmlism

import scala.language.implicitConversions

package object idioma {
  type Word = String

  implicit def stringToPhrase(string: String) = Phrase(string.split(" ").toList)
}
