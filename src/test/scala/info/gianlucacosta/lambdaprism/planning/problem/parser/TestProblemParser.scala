package info.gianlucacosta.lambdaprism.planning.problem.parser

import java.io.InputStreamReader

import info.gianlucacosta.lambdaprism.planning.problem.ExampleProblem
import org.scalatest.{FlatSpec, Matchers}

class TestProblemParser extends FlatSpec with Matchers {
  "The example problem" should "be correctly parsed from its definition in a file" in {
    val problemReader =
      new InputStreamReader(getClass.getResourceAsStream("ExampleProblem.txt"))

    try {
      val parsedProblem =
        ProblemParser.parse(problemReader)

      parsedProblem should be(ExampleProblem)
    } finally {
      problemReader.close()
    }
  }


  "The example problem" should "be correctly parsed from its string definition" in {
    val parsedProblem =
      ProblemParser.parse(ExampleProblem.toLanguageString)

    parsedProblem should be(ExampleProblem)
  }
}
