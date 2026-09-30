package info.gianlucacosta.lambdaprism.classification.basic

import org.scalatest.{FlatSpec, Matchers}

class TestEntropy extends FlatSpec with Matchers {
  "Entropy" should "be 0 when there is a single group" in {
    val testData =
      List(
        List("A", "X"),
        List("B", "X"),
        List("C", "X"),
        List("D", "X"),
        List("E", "X"),
        List("F", "X")
      )

    val entropy =
      Entropy.compute(testData)

    entropy should be(0)
  }


  "Entropy" should "be 1 when all groups are equally sized" in {
    val testData =
      List(
        List("A", "X"),
        List("B", "X"),
        List("C", "X"),
        List("D", "Y"),
        List("E", "Y"),
        List("F", "Y")
      )

    val entropy =
      Entropy.compute(testData)

    entropy should be(1)
  }


  "Entropy" should "be correct in an example case" in {
    val testData =
      List(
        List("A", "X"),
        List("B", "X"),
        List("C", "X"),
        List("D", "X"),
        List("E", "Y"),
        List("F", "Y")
      )

    val entropy =
      Entropy.compute(testData)

    entropy should be(0.91829583 +- 0.000000009)
  }
}
