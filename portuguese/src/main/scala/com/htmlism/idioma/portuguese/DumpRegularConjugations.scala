package com.htmlism.idioma.portuguese

/**
  * Prints textual tables demonstrating the ability to programmatically conjugate regular verbs
  */
object DumpRegularConjugations extends App:
  val verbs = List(
    "fal"    -> resources.firstConjugation,
    "com"    -> resources.secondConjugation,
    "assist" -> resources.thirdConjugation
  )

  for (root, conjugation) <- verbs do
    println()

    val columns = for t <- List(Presente, Perfeito, Imperfeito) yield
      val inflections =
        for
          n <- CategoriasGramaticais.Numeros;
          p <- CategoriasGramaticais.Pessoas
        yield conjugation(root, (t, p, n)).word

      t.key +: inflections

    val lines =
      Padder.zip(Padder.zip(columns(0), columns(1)), columns(2))

    lines.foreach(println)
