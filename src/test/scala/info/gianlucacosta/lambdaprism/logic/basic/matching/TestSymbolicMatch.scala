package info.gianlucacosta.lambdaprism.logic.basic.matching

import info.gianlucacosta.lambdaprism.logic.basic.formulas.{Constant, Variable}
import org.scalatest.{FlatSpec, Matchers}

class TestSymbolicMatch extends FlatSpec with Matchers {
  "toString" should "show the sides of the match" in {
    val symbolicMatch = SymbolicMatch.unify(
      Variable("A"),
      Constant("a")
    ).get

    symbolicMatch.toString should be("A --> a")
  }
}
