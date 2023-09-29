package com.htmlism.idioma.iberia

import cats.effect.*

object PrintSpanishVsPortuguese extends PrintSpanishVsPortuguese[IO] with IOApp.Simple

class PrintSpanishVsPortuguese[F[_]: Sync]:
  def run: F[Unit] =
    Sync[F].unit
