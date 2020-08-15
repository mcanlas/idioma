package com.htmlism.idioma.portuguese

object DumpRegularConjugations extends App {
  val verbs = Seq(
    "fal"    -> resources.firstConjugation,
    "com"    -> resources.secondConjugation,
    "assist" -> resources.thirdConjugation
  )

  for ((root, conjugation) <- verbs) {
    println

    val columns = for (t <- Seq(Presente, Perfeito, Imperfeito)) yield {
      val inflections =
        for (
          n <- CategoriasGramaticais.Numeros;
          p <- CategoriasGramaticais.Pessoas
        )
          yield conjugation(root, (t, p, n)).word

      t.key +: inflections
    }

    val lines =
      Padder.zip(Padder.zip(columns(0), columns(1)), columns(2))

    lines.foreach(println)
  }
}
