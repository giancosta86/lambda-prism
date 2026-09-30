package info.gianlucacosta.lambdaprism.planning.problem

import info.gianlucacosta.lambdaprism.logic.basic.formulas.{Argument, Literal}

/**
  * Step created by reifying a NOP action
  *
  * @param action
  * @param precondition
  */
case class NopStep private[problem](action: NopAction, precondition: Literal) extends Step {
  override val arguments: List[Argument] =
    List()

  override val preconditions: List[Literal] =
    List(precondition)

  override val effects: List[Literal] =
    List(precondition)

  override def toString: String =
    s"NOP {${precondition}}"
}
