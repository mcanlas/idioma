package com.htmlism.idioma.arabic

import com.htmlism.idioma._

object Lesson4 extends App {
  val mayIHave = "mumkin"
  val please = Seq("min", "fadlak")

  val foods =
    Seq("cola", "sandawich", "bitsa", "kebab", "falafel", "shay", "sukar")

  for (f <- foods) {
    println(Question(Seq(mayIHave, f)).render)
  }

  for (f <- foods) {
    println(Question(Seq(mayIHave, f) ++ please).render)
  }
}
