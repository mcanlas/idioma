package com.htmlism

import scala.language.implicitConversions

package object idioma {
  type Word = String
  type Phrase = List[Word]

  implicit def stringToPhrase(string: String) = string.split(" ").toList
}
