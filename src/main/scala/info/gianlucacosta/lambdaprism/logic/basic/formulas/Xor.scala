package info.gianlucacosta.lambdaprism.logic.basic.formulas

/**
  * Logic "xor".
  *
  * Requires at least 2 operands.
  *
  * @param operands
  */
case class Xor(operands: Formula*) extends Formula {
  require(operands.size >= 2)

  override def isGround: Boolean =
    operands.forall(_.isGround)
}
