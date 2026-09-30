package info.gianlucacosta.lambdaprism.logic.basic.formulas

import java.util.regex.Pattern

object Variable {
  val ValidNamePattern = Pattern.compile(raw"\b[A-Z][A-Za-z0-9_]*\b")
}

/**
  * Logic variable
  *
  * @param name
  */
case class Variable(name: String) extends Argument with Ordered[Variable] {
  require(
    Option(name).exists(_.nonEmpty),
    "Variable name not provided"
  )


  require(
    Variable.ValidNamePattern.matcher(name).matches(),
    s"Invalid variable name: '${name}'"
  )


  override def variables: Set[Variable] =
    Set(this)


  override def replaceVariable(
                                variable: Variable,
                                argument: Argument
                              ): Argument =
    if (this == variable)
      argument
    else
      this


  override def isGround: Boolean =
    false


  override def compare(that: Variable): Int =
    name.compareTo(that.name)


  override def toString: String =
    name
}
