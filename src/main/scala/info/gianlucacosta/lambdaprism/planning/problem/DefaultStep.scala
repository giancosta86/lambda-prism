package info.gianlucacosta.lambdaprism.planning.problem

import info.gianlucacosta.lambdaprism.logic.basic.formulas.{Argument, Literal}

/**
  * Default implementation of Step.
  *
  * Both its preconditions and effects cannot contain contradictions
  *
  * @param action
  * @param arguments
  * @param preconditions
  * @param effects
  */
case class DefaultStep private[problem](
                                         action: Action,
                                         arguments: List[Argument],
                                         preconditions: List[Literal],
                                         effects: List[Literal]
                                       ) extends Step {

  require(
    !preconditions.exists(leftPrecondition =>
      preconditions.exists(rightPrecondition =>
        leftPrecondition == ~rightPrecondition
      )
    ),

    s"There is a contradiction in the preconditions of step ${this}"
  )

  require(
    !effects.exists(leftEffect =>
      effects.exists(rightEffect =>
        leftEffect == ~rightEffect
      )
    ),

    s"There is a contradiction in the effects of step ${this}"
  )
}
