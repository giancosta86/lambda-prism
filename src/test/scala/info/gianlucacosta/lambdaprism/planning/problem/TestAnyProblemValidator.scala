package info.gianlucacosta.lambdaprism.planning.problem

import info.gianlucacosta.lambdaprism.logic.basic.formulas.{Constant, Variable}
import org.scalatest.FlatSpec

class TestAnyProblemValidator extends FlatSpec {
  "Validator" should "accept any problem (especially one violating PropositionalValidator)" in {
    val problem =
      Problem(
        List(
          Constant("b"),
          Constant("a")
        ),

        List(
          Variable("X")
        ),

        List(
          MainAction(
            "op",

            List(),

            List(
              Constant("d")
            ),

            List(
              Constant("a")
            )
          )
        )
      )


    ProblemValidators.AnyProblemValidator(problem)
  }
}
