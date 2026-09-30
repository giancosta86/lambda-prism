package info.gianlucacosta.lambdaprism.planning.problem

import info.gianlucacosta.lambdaprism.logic.basic.formulas.Literal

/**
  * Planning problem
  *
  * @param startLiterals
  * @param goalLiterals
  * @param mainActions
  */
case class Problem(
                    startLiterals: List[Literal],
                    goalLiterals: List[Literal],
                    mainActions: List[MainAction]
                  ) {

  require(
    startLiterals.nonEmpty,
    "At least one start literal must be provided"
  )


  require(
    goalLiterals.nonEmpty,
    "At least one goal literal must be provided"
  )



  require(
    mainActions.map(_.name).toSet.size == mainActions.size,
    "Not all the actions in the problem have a unique name"
  )


  val startAction = new StartAction(startLiterals)

  val goalAction = new GoalAction(goalLiterals)

  def toLanguageString: String =
    s"${startAction.toLanguageString}\n\n" +
      s"${goalAction.toLanguageString}\n\n\n" +
      mainActions.map(_.toLanguageString).mkString("\n\n")
}
