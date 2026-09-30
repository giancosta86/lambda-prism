package info.gianlucacosta.lambdaprism.logic.basic.formulas

/**
  * Logic "there exists": ∃
  *
  * @param variable
  * @param body
  */
case class Exists(variable: Variable)(body: Formula) extends Formula {
  override def isGround: Boolean =
    body.isGround
}
