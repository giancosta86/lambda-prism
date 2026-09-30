package info.gianlucacosta.lambdaprism.planning.problem

import info.gianlucacosta.lambdaprism.logic.basic.formulas.Constant
import org.scalatest.{FlatSpec, Matchers}


class TestProblem extends FlatSpec with Matchers {
  "A problem" should "be correctly created" in {
    Problem(
      List(
        Constant("a")
      ),

      List(
        Constant("b")
      ),

      List(
        MainAction(
          "op",
          List(),
          List(),
          List()
        )
      )
    )
  }


  "A problem" should "have at least a start literal" in {
    intercept[IllegalArgumentException] {
      Problem(
        List(),

        List(
          Constant("b")
        ),

        List()
      )
    }
  }


  "A problem" should "have at least a goal literal" in {
    intercept[IllegalArgumentException] {
      Problem(
        List(
          Constant("a")
        ),

        List(),

        List()
      )
    }
  }


  "A problem" should "have main actions having unique names" in {
    intercept[IllegalArgumentException] {
      Problem(
        List(
          Constant("a")
        ),

        List(
          Constant("b")
        ),

        List(
          MainAction(
            "op",
            List(),
            List(),
            List()
          ),

          MainAction(
            "op",
            List(),
            List(),
            List()
          )
        )
      )
    }
  }
}
