package com.htmlism.idioma.arabic

import com.htmlism.idioma.*

object Lesson4:
  val mayIHave = "mumkin"
  val please   = List("min", "fadlak")

  val foods =
    List("cola", "sandawich", "bitsa", "kebab", "falafel", "shay", "sukar")

  def main(args: Array[String]): Unit =
    for f <- foods do println(Question(List(mayIHave, f)).render)

    for f <- foods do println(Question(List(mayIHave, f) ++ please).render)
