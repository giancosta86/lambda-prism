package info.gianlucacosta.lambdaprism.planning.problem

import info.gianlucacosta.lambdaprism.logic.basic.formulas.{Functor, Literal, Variable}

/**
  * Action defining intermediate steps within a plan
  *
  * @param name
  * @param parameters
  * @param preconditions
  * @param effects
  */
case class MainAction(
                       name: String,
                       parameters: List[Variable],

                       preconditions: List[Literal],
                       effects: List[Literal]
                     ) extends Action {

  override val variables =
    preconditions.flatMap(_.variables).toSet ++ effects.flatMap(_.variables).toSet


  require(Option(name).exists(_.nonEmpty))

  require(
    Functor.ValidNamePattern.matcher(name).matches(),
    s"Invalid action name: '${name}'"
  )

  require(
    parameters.toSet.subsetOf(variables),
    s"In action ${name}, all the parameters must appear in the preconditions and/or the effects"
  )

  require(
    !preconditions.exists(leftPrecondition =>
      preconditions.exists(rightPrecondition =>
        leftPrecondition == ~rightPrecondition
      )
    ),

    s"There is a contradiction in the preconditions of action ${name}"
  )


  require(
    !effects.exists(leftEffect =>
      effects.exists(rightEffect =>
        leftEffect == ~rightEffect
      )
    ),

    s"There is a contradiction in the effects of action ${name}"
  )

  require(
    !ProblemLanguage.ReservedActionNames.contains(name),
    s"Reserved action name: '${name}'"
  )


  val toLanguageString: String =
    s"${ProblemLanguage.ActionKeyword}: ${signature}\n" +
      s"${ProblemLanguage.PreconditionsKeyword}: ${preconditions.mkString(", ")}\n" +
      s"${ProblemLanguage.EffectsKeyword}: ${effects.mkString(", ")}\n"
}
