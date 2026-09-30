package info.gianlucacosta.lambdaprism.planning.problem

import info.gianlucacosta.lambdaprism.logic.basic.formulas.{CompoundFunctor, Constant, Variable}
import org.scalatest.{FlatSpec, Matchers}

class TestNopStep extends FlatSpec with Matchers {
  val nopAction =
    NopAction(
      ~CompoundFunctor(
        "g",

        List(
          Variable("A"),
          Variable("B")
        )
      )
    )


  "NOP step's string representation" should "have the same format as a NOP action" in {
    val nopStep = nopAction.reify(
      Map(
        Variable("A") -> Constant("a"),
        Variable("B") -> Constant("b")
      )
    )

    nopStep.toString should be("NOP {~g(a, b)}")
  }
}
