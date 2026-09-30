package info.gianlucacosta.lambdaprism.logic.basic.formulas

import scala.annotation.tailrec

/**
  * A logic term, which can be a constant, a variable or a compound functor
  */
trait Term extends Literal {
  /**
    * Replaces a variable with the given argument
    *
    * @param variable
    * @param argument
    * @return A new term
    */
  def replaceVariable(variable: Variable, argument: Argument): Term


  /**
    * Replaces all the given variables in the term, at the same time -
    * so, swapping variables is supported.
    *
    * @param replacements
    * @return
    */
  def replaceVariables(replacements: Map[Variable, Argument]): Term = {
    val originalVariables =
      replacements.keySet


    val originalToTempVariablesMap =
      createTempVariables(originalVariables)
        .toMap


    val termWithTempVariables = originalToTempVariablesMap.foldLeft(this) {
      case (tempTerm, (variable, tempVariable)) =>
        tempTerm.replaceVariable(variable, tempVariable)
    }


    val termWithReplacements = replacements.foldLeft(termWithTempVariables) {
      case (tempTerm, (variable, actualReplacement)) =>
        val tempVariable = originalToTempVariablesMap(variable)
        tempTerm.replaceVariable(tempVariable, actualReplacement)
    }

    termWithReplacements
  }


  private def createTempVariables(originalVariables: Set[Variable]): Set[(Variable, Variable)] =
    createTempVariables(Set(), originalVariables, originalVariables)


  @tailrec
  private def createTempVariables(
                                   cumulatedResult: Set[(Variable, Variable)],
                                   cumulatedVariables: Set[Variable],

                                   variablesToAlias: Set[Variable]
                                 ): Set[(Variable, Variable)] = {
    if (variablesToAlias.isEmpty)
      cumulatedResult
    else {
      val originalVariable =
        variablesToAlias.head

      val tempVariable =
        createTempVariable(cumulatedVariables, originalVariable)

      val newCumulatedResult =
        cumulatedResult + (originalVariable -> tempVariable)

      val newCumulatedVariables =
        cumulatedVariables + tempVariable


      createTempVariables(
        newCumulatedResult,
        newCumulatedVariables,
        variablesToAlias.tail
      )
    }
  }


  private def createTempVariable(
                                  cumulatedVariables: Set[Variable],
                                  originalVariable: Variable
                                )
  : Variable =
    Stream.from(1)
      .map(
        underscoreCount => Variable(
          originalVariable.name + ("_" * underscoreCount)
        )
      )
      .dropWhile(cumulatedVariables.contains)
      .head


  override def isPositive: Boolean =
    true


  override def unary_~ : Literal =
    NegativeLiteral(this)


  override def term: Term =
    this
}
