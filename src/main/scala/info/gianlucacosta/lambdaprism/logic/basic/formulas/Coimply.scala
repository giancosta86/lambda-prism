package info.gianlucacosta.lambdaprism.logic.basic.formulas

/**
  * Logic coimplication: ↔
  *
  * @param left
  * @param right
  */
case class Coimply(left: Formula, right: Formula) extends Formula {
  override def isGround: Boolean =
    left.isGround && right.isGround
}
