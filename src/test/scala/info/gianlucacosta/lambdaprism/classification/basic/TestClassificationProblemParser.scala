package info.gianlucacosta.lambdaprism.classification.basic

import org.scalatest.{FlatSpec, Matchers}

class TestClassificationProblemParser extends FlatSpec with Matchers {
  "The example problem" should "be parsed from its string representation" in {
    val stringRepresentation =
      ExampleProblem.toString

    val parsedProblem =
      ClassificationProblemParser.parse(stringRepresentation)


    parsedProblem should be(ExampleProblem)
  }
}
