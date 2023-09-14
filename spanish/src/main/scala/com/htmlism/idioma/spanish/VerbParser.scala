package com.htmlism.idioma.spanish

import cats.syntax.all._

case class ParsedVerb(root: String, conjugation: VerbConjugationGroup)

object ParsedVerb:
  private val verbPattern =
    """(.+)([aei])r""".r

  def unapply(s: String): Option[ParsedVerb] =
    for {
      rootAndEnding <- parseParts(s)
      conjugation   <- VerbConjugationGroup.unapply(rootAndEnding._2)
    } yield ParsedVerb(rootAndEnding._1, conjugation)

  private def parseParts(s: String) =
    s match
      case verbPattern(root, ending) =>
        Some(root -> ending)

      case _ =>
        None
