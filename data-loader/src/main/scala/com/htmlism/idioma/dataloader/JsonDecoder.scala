package com.htmlism.idioma.dataloader

import scala.deriving.Mirror

import io.circe.{Decoder => CirceDecoder}

class JsonDecoder[A](val circeDecoder: CirceDecoder[A])

object JsonDecoder:
  inline def derive[A: Mirror.Of]: JsonDecoder[A] =
    JsonDecoder(io.circe.generic.semiauto.deriveDecoder[A])

  given jsonFromCirce[A](using cd: CirceDecoder[A]): JsonDecoder[A] =
    JsonDecoder(cd)

  given listJson[A](using json: JsonDecoder[A]): JsonDecoder[List[A]] =
    JsonDecoder(CirceDecoder.decodeList(using json.circeDecoder))
