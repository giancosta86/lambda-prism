package info.gianlucacosta.lambdaprism.logic.basic.formulas

/**
  * Logic literal
  *
  */
trait Literal extends Formula {
  def unary_~ : Literal

  /**
    * The set of variables appearing in the literal
    *
    * @return
    */
  def variables: Set[Variable]

  /**
    * Tests if the literal is ground (variable-free)
    *
    * @return
    */
  def isGround: Boolean


  /**
    * True if the literal is positive
    *
    * @return
    */
  def isPositive: Boolean


  /**
    * Replaces multiple variables <b>at the same time</b> (therefore, variables can be <b>swapped</b>)
    *
    * @param replacements
    * @return
    */
  def replaceVariables(replacements: Map[Variable, Argument]): Literal


  /**
    * The underlying term
    *
    * @return
    */
  def term: Term
}
