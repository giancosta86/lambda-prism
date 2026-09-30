package info.gianlucacosta.lambdaprism.planning.problem

object ProblemValidators {
  /**
    * Does not perform any check on the problem
    */
  val AnyProblemValidator = (problem: Problem) => ()


  /**
    * Enforces that:
    *
    * <ul>
    * <li>the start literals are all positive</li>
    * <li>the goal literals are all positive</li>
    * <li>the preconditions of main actions are all positive</li>
    * </ul>
    */
  val StrictClosedWorldValidator = (problem: Problem) => {
    problem
      .startLiterals
      .foreach(literal =>
        require(
          literal.isPositive,
          s"Negative start literal found: ${literal}"
        )
      )


    problem
      .goalLiterals
      .foreach(literal =>
        require(
          literal.isPositive,
          s"Negative goal literal found: ${literal}"
        )
      )


    problem
      .mainActions
      .foreach(mainAction =>
        mainAction
          .preconditions
          .foreach(precondition =>
            require(
              precondition.isPositive,
              s"Negative precondition found for action '${mainAction.name}': ${precondition}"
            )
          )
      )
  }


  /**
    * Enforces that the problem has:
    *
    * <ul>
    * <li>ground start literals</li>
    * <li>ground goal literals</li>
    * </ul>
    */
  val PropositionalValidator = (problem: Problem) => {
    problem.startLiterals.foreach(startLiteral =>
      require(
        startLiteral.isGround,
        s"Non-ground start literal found: ${startLiteral}"
      )
    )


    problem.goalLiterals.foreach(goalLiteral =>
      require(
        goalLiteral.isGround,
        s"Non-ground goal literal found: ${goalLiteral}"
      )
    )
  }


  val HasMainActionsValidator = (problem: Problem) => {
    require(
      problem.mainActions.nonEmpty,

      "At least an action must be declared"
    )
  }


  def CompositeValidator(validators: ProblemValidator*): ProblemValidator =
    (problem: Problem) => {
      validators.foreach(_ (problem))
    }
}
