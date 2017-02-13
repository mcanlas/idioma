package com.htmlism.idioma

trait TranslationAnkiCard extends AnkiCard {
  def id = (getClass.getName.hashCode + word.hashCode).toString

  def word: ChineseWord
}

case class EnglishToChinese(word: ChineseWord) extends TranslationAnkiCard {
  def front: String = ???

  def back: String = ???
}

case class ReadChinese(word: ChineseWord) extends TranslationAnkiCard {
  def front: String =
    s"""<div id="preface">How do you read ths?</div>""" +
      s"""<div id="heroic-hanzi">${word.chinese}</div>"""

  def back: String =
    s"""<div id="heroic-prompt-english">${word.pinyin}</div>""" +
    s"""<div>${word.english}</div>"""
}

case class PinyinToChinese(word: ChineseWord) extends TranslationAnkiCard {
  def front: String =
    s"""<div id="preface">How do you write this in Chinese?</div>""" +
      s"""<div id="heroic-prompt-korean">${word.pinyin}</div>"""

  def back: String =
    s"""<div id="heroic-prompt-korean">${word.chinese}</div>"""
}

case class EnglishToPinyin(word: ChineseWord) extends TranslationAnkiCard {
  def front: String =
    s"""<div id="preface">How do you write this in Pinyin?</div>""" +
      s"""<div id="heroic-prompt-english">${word.english}</div>"""


  def back: String =
    s"""<div id="heroic-prompt-korean">${word.pinyin}</div>"""
}

case class PinyinToEnglish(word: ChineseWord) extends TranslationAnkiCard {
  def front: String =
    s"""<div id="preface">What does this mean?</div>""" +
    s"""<div id="heroic-prompt-korean">${word.pinyin}</div>"""


  def back: String =
    s"""<div id="heroic-prompt-english">${word.english}</div>"""
}
