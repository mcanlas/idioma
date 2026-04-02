package com.htmlism.idioma.tagalog

import com.htmlism.idioma.*

object Magandang:
  val adjective = Phrase("magandang" :: Nil) :: Nil

  def main(args: Array[String]): Unit =
    (adjective * Data.periods).iterator.foreach { case (adj, period) =>
      println(Statement((adj + period).words).render)
    }
