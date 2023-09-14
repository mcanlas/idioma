package com.htmlism.idioma

import com.htmlism.idioma._
import com.htmlism.idioma.dataloader._

object VerbCards extends TranslationCardIterator:
  def partsIterator: Iterator[(String, String, String)] =
    DataLoader
      .getJsonUnsafe[Map[String, Verb]](getClass.getResourceAsStream("/verbs.json"))
      .toList
      .map { case (eng, verb) =>
        (eng, "to " + eng, verb.korean)
      }
      .iterator

case class Verb(korean: String)

object Verb:
  given JsonDecoder[Verb] =
    JsonDecoder.derive
