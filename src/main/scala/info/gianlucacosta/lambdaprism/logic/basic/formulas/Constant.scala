package info.gianlucacosta.lambdaprism.logic.basic.formulas

/**
  * Logic constant - which is a functor having no arguments.
  *
  * @param name
  */
case class Constant(name: String) extends Functor with Argument {
  require(
    Option(name).exists(_.nonEmpty),
    "Constant name not provided"
  )

  require(
    Functor.ValidNamePattern.matcher(name).matches(),
    s"Invalid constant name: '${name}'"
  )


  override val arguments: List[Argument] =
    List()


  override val arity: Int =
    0


  override def variables: Set[Variable] =
    Set()


  override def replaceVariable(variable: Variable, argument: Argument): Constant =
    this


  override def isGround: Boolean =
    true


  override def toString: String =
    name
}
