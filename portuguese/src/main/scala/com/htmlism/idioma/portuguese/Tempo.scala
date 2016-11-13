package com.htmlism.idioma.portuguese

object Tempo {
  def apply = CategoriasGramaticais
    .Tempos
    .map { t => t.key -> t }
    .toMap: String => Tempo
}

sealed abstract class Tempo(val key: String)

object Presente extends Tempo("present")
object Perfeito extends Tempo("perfect")
object Imperfeito extends Tempo("imperfect")
object MasQuePerfeito extends Tempo("pluperfect")
object Futuro extends Tempo("future")
object Condicional extends Tempo("conditional")
object SubjuntivoDoPresente extends Tempo("presentSubjunctive")
object SubjuntivoDoImperfeito extends Tempo("imperfectSubjunctive")
object SubjuntivoDoFuturo extends Tempo("futureSubjunctive")
