package info.gianlucacosta.lambdaprism.logic.basic.formulas

/**
  * Logic "for all": ∀
  *
  * @param variable
  * @param body
  */
case class ForAll(variable: Variable)(body: Formula) extends Formula {
  override def isGround: Boolean =
    body.isGround
}
