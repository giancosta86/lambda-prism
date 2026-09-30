package info.gianlucacosta.lambdaprism.logic.basic.formulas

/**
  * Logic "or".
  *
  * Requires at least 2 operands.
  *
  * @param operands
  */
case class Or(operands: Formula*) extends Formula {
  require(operands.size >= 2)

  override def isGround: Boolean =
    operands.forall(_.isGround)
}
