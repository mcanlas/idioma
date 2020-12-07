package com.htmlism.idioma.portuguese

package object resources {
  val matchAlternation = """(\S+\|[\S|]+)""".r

  def interpretInflection(vowel: String, s: String): String =
    s.replace("{v}", vowel)
      .replace("{inf}", vowel + "r")

  def expandUnderscore(s: String): String = s.replace("_", "first|second|third")

  def expandAlternation(s: String): Traversable[String] = {
    val alternationExpressions = matchAlternation.findAllIn(s)

    alternationExpressions.foldLeft(Seq(s)) { (acc, altExpr) =>
      val elements = altExpr.split('|')

      acc.flatMap { cur =>
        for (e <- elements) yield cur.replace(altExpr, e)
      }
    }
  }

  def getResourceLines(path: String): Iterator[String] = {
    val iterator = scala.io.Source
      .fromInputStream(getClass.getResourceAsStream(path))
      .getLines

    // skip the header row
    iterator.next()

    iterator
  }

  lazy val (firstConjugation, secondConjugation, thirdConjugation) = {
    val vowelLookup = getResourceLines("/conjugations.tsv")
      .map(_.split("\t"))
      .map { case Array(name, vowel) => name -> vowel }
      .toMap

    val conjugations = getResourceLines("/inflections.tsv")
      .map(expandUnderscore)
      .flatMap(expandAlternation)
      .map(_.split('\t'))
      .toList
      .groupBy(_(0))
      .map { case (conjugationName, inflectionRows) =>
        val vowel = vowelLookup(conjugationName)

        val inflections = inflectionRows.map { case Array(_, tense, person, number, expression) =>
          val interpolatedInflection =
            interpretInflection(vowel, expression)

          (Tempo(tense), Pessoa(person), Number(number)) -> interpolatedInflection
        }.toMap

        vowel -> inflections
      }

    (
      new FunctionConjugation("a", conjugations("a")): Conjugation,
      new FunctionConjugation("e", conjugations("e")): Conjugation,
      new FunctionConjugation("i", conjugations("i")): Conjugation
    )
  }
}
