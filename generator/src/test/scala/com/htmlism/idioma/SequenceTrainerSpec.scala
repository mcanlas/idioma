package com.htmlism.idioma

import org.specs2.mutable.Specification

class SequenceTrainerSpec extends Specification {
  "the sequence trainer" should {
    "bomb on short sequences" in {
      {
        SequenceTrainer.train(Seq.empty)
      } should throwA[IllegalArgumentException]

      {
        SequenceTrainer.train(Seq(1))
      } should throwA[IllegalArgumentException]
    }

    "echo a sequence of two elements" in {
      val (a, b, c) = SequenceTrainer.train(Seq(1, 2, 3))

      a === (1, 2)
      b.toSeq === Seq((1, 2, 3))
      c === (2, 3)
    }

    "work over a longer sequence" in {
      val (a, b, c) = SequenceTrainer.train(Seq(1, 2, 3, 4))

      a === (1, 2)
      b.toSeq === Seq((1, 2, 3), (2, 3, 4))
      c === (3, 4)
    }
  }
}
