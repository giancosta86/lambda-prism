package info.gianlucacosta.lambdaprism.logic.basic.formulas

/**
  * Logic "and".
  *
  * Requires at least 2 operands.
  *
  * @param operands
  */
case class And(operands: Formula*) extends Formula {
  require(operands.size >= 2)

  override def isGround: Boolean =
    operands.forall(_.isGround)
}
