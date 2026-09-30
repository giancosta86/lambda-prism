package info.gianlucacosta.lambdaprism.planning.problem

import info.gianlucacosta.lambdaprism.logic.basic.formulas.{CompoundFunctor, Constant, Variable}
import org.scalatest.{FlatSpec, Matchers}


class TestGoalAction extends FlatSpec with Matchers {
  val goalLiterals = List(
    Constant("b"),
    CompoundFunctor(
      "f",

      List(
        Constant("c"),
        Variable("A"),
        Constant("d")
      )
    )
  )

  val goalAction =
    GoalAction(goalLiterals)


  "Name" should "be a constant" in {
    goalAction.name should be(GoalAction.Name)
  }


  "Parameters" should "be empty" in {
    goalAction.parameters should be(empty)
  }


  "Preconditions" should "be the goal literals" in {
    goalAction.preconditions should be(goalLiterals)
  }


  "Effects" should "be empty" in {
    goalAction.effects should be(empty)
  }


  "Variables" should "include the variables of the goal literals" in {
    goalAction.variables should be(Set(
      Variable("A")
    ))
  }


  "Reify" should "work" in {
    val groundLiterals = List(
      Constant("b"),
      CompoundFunctor(
        "f",

        List(
          Constant("c"),
          Constant("a"),
          Constant("d")
        )
      )
    )


    val goalStep = goalAction.reify(Map(
      Variable("A") -> Constant("a")
    ))


    goalStep.action should be(goalAction)

    goalStep.arguments should be(empty)

    goalStep.preconditions should be(groundLiterals)

    goalStep.effects should be(empty)

    goalStep.addedEffects should be(empty)

    goalStep.deletedEffects should be(empty)
  }
}
