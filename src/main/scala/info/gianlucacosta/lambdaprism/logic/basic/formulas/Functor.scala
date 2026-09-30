package info.gianlucacosta.lambdaprism.logic.basic.formulas

import java.util.regex.Pattern


object Functor {
  val ValidNamePattern = Pattern.compile(raw"\b[a-z0-9][A-Za-z0-9_]*\b")
}


/**
  * Logic functor, having arbitrary arity
  */
trait Functor extends Term with Ordered[Functor] {
  /**
    * The functor's name
    */
  def name: String

  /**
    * The arguments passed to the functor
    *
    * @return
    */
  def arguments: List[Argument]


  /**
    * The number of arguments
    */
  def arity: Int =
    arguments.size


  override def replaceVariable(variable: Variable, argument: Argument): Functor


  override def compare(that: Functor): Int = {
    val nameResult = name.compareTo(that.name)

    if (nameResult != 0)
      nameResult
    else {
      val arityResult = arity.compareTo(that.arity)

      arityResult
    }
  }
}
