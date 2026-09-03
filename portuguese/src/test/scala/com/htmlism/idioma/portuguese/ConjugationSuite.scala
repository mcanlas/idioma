package com.htmlism.idioma.portuguese

import weaver.*

object ConjugaçãoSuite extends FunSuite:
  test("parse regular conjugation endings"):
    expect.eql(
      List("fal" -> "a", "com" -> "e", "assist" -> "i"),
      List("falar", "comer", "assistir").flatMap { infinitive =>
        Conjugação(infinitive).map { case (root, conjugation) =>
          root -> conjugation.vowel
        }
      }
    )

  test("reject unsupported conjugation endings"):
    expect(Conjugação("pôr").isEmpty)
