package com.htmlism.idioma

import com.htmlism.idioma._
import com.htmlism.idioma.dataloader._

object NounCards extends TranslationCardIterator:
  def partsIterator: Iterator[(String, String, String)] =
    DataLoader
      .getJsonUnsafe[Map[String, Noun]](getClass.getResourceAsStream("/nouns.json"))
      .toList
      .map { case (eng, noun) =>
        (eng, eng, noun.hangul)
      }
      .iterator

case class Noun(hangul: String)

object Noun:
  given JsonDecoder[Noun] =
    JsonDecoder.derive
