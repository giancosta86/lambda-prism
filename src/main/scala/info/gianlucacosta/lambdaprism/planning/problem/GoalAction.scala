package info.gianlucacosta.lambdaprism.planning.problem

import info.gianlucacosta.lambdaprism.logic.basic.formulas.Literal

case object GoalAction {
  val Name: String = "goal"
}

/**
  * Action describing the goal of a planning problem
  *
  * @param goalLiterals
  */
case class GoalAction(goalLiterals: List[Literal]) extends Action {
  override val name = GoalAction.Name
  override val parameters = List()
  override val preconditions = goalLiterals
  override val effects = List()
  override val variables = goalLiterals.flatMap(_.variables).toSet

  override def toLanguageString: String =
    s"${ProblemLanguage.GoalKeyword}: ${goalLiterals.mkString(", ")}"
}
