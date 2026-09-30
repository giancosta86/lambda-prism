package info.gianlucacosta.lambdaprism.logic.basic.formulas

/**
  * Logic implication: →
  *
  * @param ifPart
  * @param thenPart
  */
case class Imply(ifPart: Formula, thenPart: Formula) extends Formula {
  override def isGround: Boolean =
    ifPart.isGround && thenPart.isGround
}
