package com.htmlism.idioma.arabic

import com.htmlism.idioma.*

object Lesson4 extends App:
  val mayIHave = "mumkin"
  val please   = List("min", "fadlak")

  val foods =
    List("cola", "sandawich", "bitsa", "kebab", "falafel", "shay", "sukar")

  for f <- foods do println(Question(List(mayIHave, f)).render)

  for f <- foods do println(Question(List(mayIHave, f) ++ please).render)
