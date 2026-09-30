package info.gianlucacosta.lambdaprism.logic.basic.formulas

object Argument {
  /**
    * Parses the given string and returns a suitable instance of Argument
    *
    * @param argumentToken
    * @return
    */
  def parse(argumentToken: String): Argument = {
    require(
      Option(argumentToken).exists(_.nonEmpty),
      "Argument token not provided"
    )

    if (Functor.ValidNamePattern.matcher(argumentToken).matches()) {
      Constant(argumentToken)
    } else if (Variable.ValidNamePattern.matcher(argumentToken).matches()) {
      Variable(argumentToken)
    } else {
      throw new IllegalArgumentException(s"Invalid token: '${argumentToken}'")
    }
  }
}


/**
  * Argument of a functor: in this simplified model, it can only be a constant or a variable.
  */
trait Argument extends Term {
  override def replaceVariable(variable: Variable, argument: Argument): Argument

  override def replaceVariables(replacements: Map[Variable, Argument]): Argument =
    super.replaceVariables(replacements).asInstanceOf[Argument]
}