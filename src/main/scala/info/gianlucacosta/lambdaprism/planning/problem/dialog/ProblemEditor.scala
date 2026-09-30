package info.gianlucacosta.lambdaprism.planning.problem.dialog

import info.gianlucacosta.lambdaprism.logic.basic.formulas.{Functor, Variable}
import info.gianlucacosta.lambdaprism.planning.problem.ProblemLanguage
import info.gianlucacosta.omnieditor.StyledCodeEditor

/**
  * Editor dedicated to the definition of a planning problem
  */
class ProblemEditor extends StyledCodeEditor {
  setWrapText(true)

  getStyleClass.add("problemEditor")

  addPattern("comment", ProblemLanguage.CommentPattern)
  addTokens("keyword", ProblemLanguage.Keywords: _*)

  addPattern("constantName", Functor.ValidNamePattern.pattern())
  addPattern("variableName", Variable.ValidNamePattern.pattern())
}
