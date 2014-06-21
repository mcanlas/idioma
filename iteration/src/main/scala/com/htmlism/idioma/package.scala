package com.htmlism

package object idioma {
  type Word = String
  type Phrase = List[Word]

  implicit def stringToPhrase(string: String) = string.split(" ").toList
}
