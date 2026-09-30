package info.gianlucacosta.lambdaprism.planning.problem

import info.gianlucacosta.lambdaprism.logic.basic.formulas.{Constant, Variable}
import org.scalatest.{FlatSpec, Matchers}


class TestHasMainActionsValidator extends FlatSpec with Matchers {
  "Validator" should "succeed if a main action is defined" in {
    val problem =
      Problem(
        List(
          Constant("b")
        ),

        List(
          Constant("c")
        ),

        List(
          MainAction(
            "op",

            List(
              Variable("A")
            ),

            List(
              Constant("d")
            ),

            List(
              Variable("A")
            )
          )
        )
      )


    ProblemValidators.HasMainActionsValidator(problem)
  }


  "Validator" should "fail if no main actions are defined" in {
    val problem =
      Problem(
        List(
          Constant("b")
        ),

        List(
          Constant("c")
        ),

        List()
      )


    intercept[IllegalArgumentException] {
      ProblemValidators.HasMainActionsValidator(problem)
    }
  }
}
