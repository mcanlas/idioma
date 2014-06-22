package com.htmlism.idioma.portuguese

import com.htmlism.idioma._
import com.htmlism.idioma.portuguese.GrammaticalCategories._

object Falar extends App {
  val verbForms = Generator(Seq(Singular, Plural)) + Generator(Seq(FirstPerson, ThirdPerson))
  val tenses    = Generator(Seq('present, 'perfect, 'imperfect, 'future, 'presentProgressive, 'pastProgressive))

  (tenses + verbForms + Data.idiomas).iterator.foreach { println }
}
