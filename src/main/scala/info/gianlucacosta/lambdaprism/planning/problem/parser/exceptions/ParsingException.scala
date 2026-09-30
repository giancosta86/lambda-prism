package info.gianlucacosta.lambdaprism.planning.problem.parser.exceptions

class ParsingException(message: String, cause: Throwable) extends RuntimeException(message, cause) {
  def this(message: String) = this(message, null)
}