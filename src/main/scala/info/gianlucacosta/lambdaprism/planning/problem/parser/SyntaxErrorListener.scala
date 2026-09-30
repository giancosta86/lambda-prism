package info.gianlucacosta.lambdaprism.planning.problem.parser

import info.gianlucacosta.lambdaprism.planning.problem.parser.exceptions.SyntaxException
import org.antlr.v4.runtime.{BaseErrorListener, RecognitionException, Recognizer}


private class SyntaxErrorListener extends BaseErrorListener {
  override def syntaxError(recognizer: Recognizer[_, _], offendingSymbol: scala.Any, line: Int, charPositionInLine: Int, msg: String, e: RecognitionException): Unit =
    throw new SyntaxException(line, charPositionInLine, msg, offendingSymbol, e)
}
