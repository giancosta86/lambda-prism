package info.gianlucacosta.lambdaprism.planning.problem.parser

import java.io.{Reader, StringReader}

import info.gianlucacosta.lambdaprism.planning.problem.Problem
import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream}

/**
  * Creates a planning problem after reading its definition from different sources
  */
object ProblemParser {
  /**
    * Reads a problem definition from the given reader
    *
    * @param sourceReader
    * @return
    */
  def parse(sourceReader: Reader): Problem = {
    val charStream = new ANTLRInputStream(sourceReader)
    val lexer = new PlanningProblemLexer(charStream)
    val tokenStream = new CommonTokenStream(lexer)

    val parser = new PlanningProblemParser(tokenStream)

    lexer.removeErrorListeners()
    parser.removeErrorListeners()
    parser.addErrorListener(new SyntaxErrorListener)

    val problemContext = parser.problem()

    val problemBuildingVisitor = new ProblemBuildingVisitor
    problemBuildingVisitor.visitProblem(problemContext)
  }


  /**
    * Reads a problem definition from the given string
    *
    * @param sourceString
    * @return
    */
  def parse(sourceString: String): Problem =
    parse(new StringReader(sourceString))
}
