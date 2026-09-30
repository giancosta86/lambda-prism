package info.gianlucacosta.lambdaprism.logic.basic.formulas

import org.scalatest.{FlatSpec, Matchers}

class TestArgument extends FlatSpec with Matchers {
  "Parsing a lowercase token" should "return a constant" in {
    Argument.parse("alpha") should be(Constant("alpha"))
  }


  "Parsing an uppercase token" should "return a variable" in {
    Argument.parse("Alpha") should be(Variable("Alpha"))
  }


  "Parsing a null token" should "throw an exception" in {
    intercept[IllegalArgumentException] {
      Argument.parse(null)
    }
  }


  "Parsing an empty token" should "throw an exception" in {
    intercept[IllegalArgumentException] {
      Argument.parse("")
    }
  }


  "Parsing a token with an invalid char" should "throw an exception" in {
    intercept[IllegalArgumentException] {
      Argument.parse("axv$ty")
    }
  }
}
