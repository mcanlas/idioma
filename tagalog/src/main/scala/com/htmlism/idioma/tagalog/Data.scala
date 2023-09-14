package com.htmlism.idioma.tagalog

import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

import com.htmlism.idioma._
import com.htmlism.idioma.dataloader._

object Data:
  lazy val periods: List[Phrase] =
    DataLoader
      .getJsonUnsafe[List[Noun]]("nouns.json")
      .map(n => Phrase(List(n.lemma)))

case class Noun(lemma: String, gloss: String)

object Noun:
  given Decoder[Noun] =
    deriveDecoder
