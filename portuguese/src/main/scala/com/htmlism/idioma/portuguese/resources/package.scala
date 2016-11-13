package com.htmlism.idioma.portuguese

package object resources {
  val matchAlternation = """(\S+\|[\S|]+)""".r

  def interpretUnderscore(s: String): String = s.replace("_", "first|second|third")

  def expandAlternation(s: String): Traversable[String] =
    matchAlternation.findFirstIn(s) match {
      case Some(altExpr) =>
        val possibilities = altExpr.split('|')

        for (p <- possibilities) yield
          s.replace(altExpr, p)

      case None =>
        Seq(s)
    }
}
