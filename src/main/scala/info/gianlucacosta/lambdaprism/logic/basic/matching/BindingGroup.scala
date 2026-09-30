package info.gianlucacosta.lambdaprism.logic.basic.matching

import info.gianlucacosta.lambdaprism.logic.basic.formulas.{Constant, Variable}

/**
  * A binding group consists of:
  *
  * <ul>
  * <li>
  * A set of variables, constrained to have the very same value, which could be undefined
  * </li>
  *
  * <li>
  * The ground value assigned to every variable: Some(Constant) or None (if it is undefined)
  * </li>
  * </ul>
  *
  * @param variables
  * @param ground
  */
case class BindingGroup(variables: Set[Variable], ground: Option[Constant]) {
  require(variables.nonEmpty)

  lazy val sortedVariables =
    variables.toList.sorted


  def contains(variable: Variable): Boolean =
    variables.contains(variable)


  override def toString: String =
    sortedVariables.mkString(" = ") +
      ground.map(actualGround => s" = ${actualGround}").getOrElse("")
}
