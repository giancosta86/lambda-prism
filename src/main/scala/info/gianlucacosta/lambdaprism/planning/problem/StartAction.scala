package info.gianlucacosta.lambdaprism.planning.problem

import info.gianlucacosta.lambdaprism.logic.basic.formulas.Literal


case object StartAction {
  val Name = "start"
}


/**
  * Action describing the initial state of a planning problem
  *
  * @param startLiterals
  */
case class StartAction(startLiterals: List[Literal]) extends Action {
  override val name = StartAction.Name
  override val parameters = List()
  override val preconditions = List()
  override val effects = startLiterals
  override val variables = startLiterals.flatMap(_.variables).toSet

  override def toLanguageString: String =
    s"${ProblemLanguage.StartKeyword}: ${startLiterals.mkString(", ")}"

}