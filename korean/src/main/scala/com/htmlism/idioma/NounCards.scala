package com.htmlism.idioma

import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

import com.htmlism.idioma._
import com.htmlism.idioma.dataloader._

object NounCards extends TranslationCardIterator:
  def partsIterator: Iterator[(String, String, String)] =
    DataLoader
      .getJsonUnsafe[Map[String, Noun]]("nouns.json")
      .toList
      .map { case (eng, noun) =>
        (eng, eng, noun.hangul)
      }
      .iterator

case class Noun(hangul: String)

object Noun:
  given Decoder[Noun] =
    deriveDecoder
