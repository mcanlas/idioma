package com.htmlism.idioma

import scala.jdk.CollectionConverters._

import org.yaml.snakeyaml.Yaml

object GenerateWordCards extends AnkiCardGenerator {
  def cards: Iterator[AnkiCard] =
    ChineseWordProvider.iterator.map(ReadChinese) ++
      ChineseWordProvider.iterator.map(PinyinToChinese) ++
      ChineseWordProvider.iterator.map(EnglishToPinyin) ++
      ChineseWordProvider.iterator.map(PinyinToEnglish)
}

case class ChineseWord(pinyin: String, english: String, chinese: String)

object ChineseWordProvider extends Iterable[ChineseWord] {
  def asList[A](f: Any => A)(x: Any): List[A] =
    x match {
      case xs: java.util.ArrayList[_] =>
        xs.asScala.toList.map { y =>
          f(y)
        }

      case _ =>
        Nil
    }

  def asMap[A, B](f: Any => A, g: Any => B)(x: Any): Map[A, B] =
    x match {
      case xs: java.util.LinkedHashMap[_, _] =>
        xs.asScala.iterator.map { case (a, b) => f(a) -> g(b) }.toMap

      case _ =>
        Map.empty
    }

  def iterator: Iterator[ChineseWord] = {
    val is  = getClass.getResourceAsStream("/words.yaml")
    val doc = (new Yaml).load(is): Object

    val words = asList(asMap(_.toString, _.toString))(doc)

    words
      .iterator
      .map { fields =>
        val chinese = fields("zh")
        val english = fields("en")
        val pinyin  = fields("py")

        ChineseWord(pinyin, english, chinese)
      }
  }
}

object Tester extends App {
  ChineseWordProvider.toList.foreach(println)
}
