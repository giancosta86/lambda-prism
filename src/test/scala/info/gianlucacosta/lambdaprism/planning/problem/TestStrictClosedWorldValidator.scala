package info.gianlucacosta.lambdaprism.planning.problem

import info.gianlucacosta.lambdaprism.logic.basic.formulas.{Constant, Variable}
import org.scalatest.{FlatSpec, Matchers}


class TestStrictClosedWorldValidator extends FlatSpec with Matchers {

  "Validator" should "accept a problem having only positive literals" in {
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


    ProblemValidators.StrictClosedWorldValidator(
      problem
    )
  }


  "Validator" should "refuse negative start literals" in {
    val problem =
      Problem(
        List(
          ~Constant("b")
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


    intercept[IllegalArgumentException] {
      ProblemValidators.StrictClosedWorldValidator(
        problem
      )
    }
  }


  "Validator" should "refuse negative goal literals" in {
    val problem =
      Problem(
        List(
          Constant("b")
        ),

        List(
          ~Constant("c")
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


    intercept[IllegalArgumentException] {
      ProblemValidators.StrictClosedWorldValidator(
        problem
      )
    }
  }



  "Validator" should "refuse negative main action preconditions" in {
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
              ~Constant("d")
            ),

            List(
              Variable("A")
            )
          )
        )
      )


    intercept[IllegalArgumentException] {
      ProblemValidators.StrictClosedWorldValidator(
        problem
      )
    }
  }




  "Validator" should "accept negative main action effects" in {
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
              ~Variable("A")
            )
          )
        )
      )


    ProblemValidators.StrictClosedWorldValidator(
      problem
    )
  }
}
