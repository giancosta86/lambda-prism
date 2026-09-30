package info.gianlucacosta.lambdaprism.logic.basic.formulas

private case class NegativeLiteral(term: Term) extends Literal {
  override def unary_~ : Literal =
    term


  override def isGround: Boolean =
    term.isGround


  override def variables: Set[Variable] =
    term.variables


  override def isPositive: Boolean =
    false


  override def replaceVariables(replacements: Map[Variable, Argument]): NegativeLiteral =
    copy(term = term.replaceVariables(replacements))


  override def toString: String =
    s"~${term}"
}
