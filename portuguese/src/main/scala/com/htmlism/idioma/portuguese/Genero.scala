package com.htmlism.idioma.portuguese

import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

enum Gender:
  case Masculine
  case Feminine
  case Neuter

object Gender:
  given Decoder[Gender] =
    deriveDecoder
