package info.gianlucacosta.lambdaprism.logic.basic.formulas

import org.scalatest.{FlatSpec, Matchers}

class TestFunctor extends FlatSpec with Matchers {
  "Constants" should "be sorted according to their name" in {
    val left =
      Constant("f")

    val right =
      Constant("g")

    (left < right) should be(true)
  }



  "A constant" should "be sorted before a compound functor having its same name" in {
    val left =
      Constant("f")

    val right =
      CompoundFunctor(
        "f",
        List(
          Variable("A")
        )
      )

    (left < right) should be(true)
  }


  "f(A)" should "be sorted before F(A, B)" in {
    val left =
      CompoundFunctor(
        "f",
        List(
          Variable("A")
        )
      )

    val right =
      CompoundFunctor(
        "f",
        List(
          Variable("A"),
          Variable("B")
        )
      )

    (left < right) should be(true)
  }


  "f(A, B)" should "be sorted before g(A)" in {
    val left =
      CompoundFunctor(
        "f",
        List(
          Variable("A"),
          Variable("B")
        )
      )

    val right =
      CompoundFunctor(
        "g",
        List(
          Variable("A")
        )
      )

    (left < right) should be(true)
  }
}
