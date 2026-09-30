package info.gianlucacosta.lambdaprism.logic.basic.formulas

class TestAnd extends TestFormula[And] {
  "And" should "require at least 2 operands" in {
    intercept[IllegalArgumentException] {
      And(
        Variable("X")
      )
    }
  }

  "And" should "support 2 operands" in {
    And(
      Variable("X"),
      Variable("Y")
    )
  }


  "And" should "support 3 or more operands" in {
    And(
      Variable("X"),
      Variable("Y"),
      Variable("Z")
    )
  }


  override protected def createGroundFormula(): And =
    And(
      Constant("a"),
      Constant("b")
    )


  override protected def createNonGroundFormula(): And =
    And(
      Constant("a"),

      CompoundFunctor(
        "f",
        List(
          Constant("b"),
          Variable("X"),
          Constant("c")
        )
      )
    )
}
