package com.htmlism.idioma

import scala.jdk.CollectionConverters.*

import org.yaml.snakeyaml.Yaml

object GenerateWordCards extends AnkiCardGenerator:
  def cards: Iterator[AnkiCard] =
    ChineseWordProvider.iterator.map(ReadChinese.apply) ++
      ChineseWordProvider.iterator.map(PinyinToChinese.apply) ++
      ChineseWordProvider.iterator.map(EnglishToPinyin.apply) ++
      ChineseWordProvider.iterator.map(PinyinToEnglish.apply)

case class ChineseWord(pinyin: String, english: String, chinese: String)

object ChineseWordProvider extends Iterable[ChineseWord]:
  def asList[A](f: Any => A)(x: Any): List[A] =
    x match
      case xs: java.util.ArrayList[?] =>
        xs.asScala.toList.map { y =>
          f(y)
        }

      case _ =>
        Nil

  def asMap[A, B](f: Any => A, g: Any => B)(x: Any): Map[A, B] =
    x match
      case xs: java.util.LinkedHashMap[?, ?] =>
        xs.asScala.iterator.map { case (a, b) => f(a) -> g(b) }.toMap

      case _ =>
        Map.empty

  def iterator: Iterator[ChineseWord] =
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

object Tester extends App:
  ChineseWordProvider.toList.foreach(println)
