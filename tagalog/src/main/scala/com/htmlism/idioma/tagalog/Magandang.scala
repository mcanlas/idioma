package com.htmlism.idioma.tagalog

import com.htmlism.idioma._

object Magandang extends App {
  val adjective = Generator(new Phrase("magandang" :: Nil) :: Nil)

  (adjective + Data.periods).iterator.foreach { case (adj, period) =>
    println(new Sentence((adj + period).words).render)
  }
}
