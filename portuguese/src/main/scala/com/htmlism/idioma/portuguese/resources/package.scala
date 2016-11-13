package com.htmlism.idioma.portuguese

package object resources {
  val matchAlternation = """(\S+\|[\S|]+)""".r

  def interpretUnderscore(s: String): String = s.replace("_", "first|second|third")

  def expandAlternation(s: String): Traversable[String] =
    matchAlternation.findFirstIn(s) match {
      case Some(altExpr) =>
        val elements = altExpr.split('|')

        for (e <- elements) yield
          s.replace(altExpr, e)

      case None =>
        Seq(s)
    }

  def getResourceLines(path: String): Iterator[String] = {
    val iterator = scala.io.Source.fromInputStream(getClass.getResourceAsStream(path)).getLines

    // skip the header row
    iterator.next()

    iterator
  }
}
