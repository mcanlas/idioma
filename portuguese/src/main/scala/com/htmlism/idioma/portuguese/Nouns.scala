package com.htmlism.idioma.portuguese

import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

import com.htmlism.idioma.dataloader._
import com.htmlism.idioma.portuguese.CategoriasGramaticais.*

/**
  * Demonstrates the ability to inflect nouns programmatically
  */
object Nouns extends App:
  val declensions =
    DataLoader
      .getJsonUnsafe[List[Noun]](getClass.getResourceAsStream("/nouns.json"))
      .map(n => Declension(n.lemma, n.gender, n.plural))

  declensions.foreach { d =>
    println(d(Singular))
    println(d(Plural))

    println(d(Singular, Indefinitivo))
    println(d(Plural, Indefinitivo))

    println(d(Singular, Definitivo))
    println(d(Plural, Definitivo))
  }

case class Noun(lemma: String, gender: Gender, gloss: String, plural: Option[String])

object Noun:
  given Decoder[Noun] =
    deriveDecoder
