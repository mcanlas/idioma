package com.htmlism.idioma.dataloader

import scala.deriving.Mirror

import io.circe.{ Decoder => CirceDecoder } 

class JsonDecoder[A](val circeDecoder: CirceDecoder[A])

object JsonDecoder:
  inline def derive[A : Mirror.Of]: JsonDecoder[A] =
    JsonDecoder(io.circe.generic.semiauto.deriveDecoder[A])

  given [A](using json: JsonDecoder[A]): JsonDecoder[List[A]] =
    JsonDecoder(CirceDecoder.decodeList(using json.circeDecoder))
