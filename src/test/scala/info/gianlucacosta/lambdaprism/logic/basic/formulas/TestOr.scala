package info.gianlucacosta.lambdaprism.logic.basic.formulas

class TestOr extends TestFormula[Or] {
  "Or" should "require at least 2 operands" in {
    intercept[IllegalArgumentException] {
      Or(
        Variable("X")
      )
    }
  }

  "Or" should "support 2 operands" in {
    Or(
      Variable("X"),
      Variable("Y")
    )
  }


  "Or" should "support 3 or more operands" in {
    Or(
      Variable("X"),
      Variable("Y"),
      Variable("Z")
    )
  }


  override protected def createGroundFormula(): Or =
    Or(
      Constant("a"),
      Constant("b")
    )

  override protected def createNonGroundFormula(): Or =
    Or(
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
