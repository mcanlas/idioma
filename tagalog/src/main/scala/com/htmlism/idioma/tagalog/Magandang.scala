package com.htmlism.idioma.tagalog

import com.htmlism.idioma._

object Magandang extends App {
  val adjective = new Phrase("magandang" :: Nil) :: Nil

  (adjective * Data.periods).iterator.foreach { case (adj, period) =>
    println(Statement((adj + period).words).render)
  }
}
