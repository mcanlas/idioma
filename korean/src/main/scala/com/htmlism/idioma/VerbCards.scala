package com.htmlism.idioma

import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

import com.htmlism.idioma.*
import com.htmlism.idioma.dataloader.*

object VerbCards extends TranslationCardIterator:
  def partsIterator: Iterator[(String, String, String)] =
    DataLoader
      .getJsonUnsafe[Map[String, Verb]]("verbs.json")
      .toList
      .map { case (eng, verb) =>
        (eng, "to " + eng, verb.korean)
      }
      .iterator

case class Verb(korean: String)

object Verb:
  given Decoder[Verb] =
    deriveDecoder
