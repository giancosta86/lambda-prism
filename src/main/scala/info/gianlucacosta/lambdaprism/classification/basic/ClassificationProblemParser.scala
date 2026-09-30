package info.gianlucacosta.lambdaprism.classification.basic

/**
  * Parser for ClassificationProblem
  */
object ClassificationProblemParser {
  /**
    * Reads a problem definition from the given string
    *
    * @param sourceString The source string. Lines are trimmed, then empty lines are ignored.
    * @return
    */
  def parse(sourceString: String): ClassificationProblem = {
    val actualLines =
      sourceString
        .split('\n')
        .map(_.trim)
        .filter(_.nonEmpty)
        .map(line =>
          line
            .split(raw"\s*,\s*")
            .toList
        )
        .toList


    require(
      actualLines.nonEmpty,
      "No attributes declared"
    )

    val attributes :: valueTable =
      actualLines

    ClassificationProblem(
      attributes,
      valueTable
    )
  }

}
