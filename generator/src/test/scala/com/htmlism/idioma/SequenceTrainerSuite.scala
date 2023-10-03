package com.htmlism.idioma

import scala.util.*

import weaver.*

object SequenceTrainerSuite extends FunSuite:
  test("bomb on short sequences"):
    matches(Try(SequenceTrainer.train(Seq.empty[String]))) { case Failure(_) =>
      success
    } and matches(Try(SequenceTrainer.train(Seq(1)))) { case Failure(_) =>
      success
    }

  test("echo a sequence of two elements"):
    val (a, b, c) = SequenceTrainer.train(Seq(1, 2, 3))

    expect.eql((1, 2), a) and
      expect.eql(Seq((1, 2, 3)), b.toSeq) and
      expect.eql((2, 3), c)

  test("work over a longer sequence"):
    val (a, b, c) = SequenceTrainer.train(Seq(1, 2, 3, 4))

    expect.eql((1, 2), a) and
      expect.eql(Seq((1, 2, 3), (2, 3, 4)), b.toSeq) and
      expect.eql((3, 4), c)
