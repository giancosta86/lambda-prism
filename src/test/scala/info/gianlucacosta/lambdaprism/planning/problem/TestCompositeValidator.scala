package info.gianlucacosta.lambdaprism.planning.problem

import info.gianlucacosta.lambdaprism.logic.basic.formulas.{Constant, Variable}
import org.scalatest.{FlatSpec, Matchers}

class TestCompositeValidator extends FlatSpec with Matchers {
  "Validator" should "apply all the provided validators" in {
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

    val compositeValidator =
      ProblemValidators.CompositeValidator(
        ProblemValidators.AnyProblemValidator,
        ProblemValidators.PropositionalValidator
      )


    intercept[IllegalArgumentException] {
      compositeValidator(problem)
    }
  }
}
