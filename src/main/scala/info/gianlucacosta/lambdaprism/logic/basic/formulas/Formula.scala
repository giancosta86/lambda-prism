package info.gianlucacosta.lambdaprism.logic.basic.formulas

/**
  * Logic formula
  */
trait Formula {
  /**
    * Tests if the formula is ground (variable-free)
    *
    * @return
    */
  def isGround: Boolean
}
