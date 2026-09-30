package info.gianlucacosta.lambdaprism.planning.problem

import info.gianlucacosta.lambdaprism.logic.basic.formulas.{Argument, Literal, Variable}

/**
  * NOP action - that is, an action whose only effect is its precondition
  *
  * @param precondition
  */
case class NopAction(precondition: Literal) extends Action {
  override val name: String =
    s"NOP {${precondition}}"


  override val parameters: List[Variable] =
    List()

  override val preconditions: List[Literal] =
    List(precondition)

  override val effects: List[Literal] =
    List(precondition)


  override def toLanguageString: String =
    throw new UnsupportedOperationException

  override val variables: Set[Variable] =
    precondition.variables


  override def reify(argumentMap: Map[Variable, Argument]): NopStep = {
    require(variables.subsetOf(argumentMap.keySet))

    NopStep(
      this,
      precondition.replaceVariables(argumentMap)
    )
  }
}
