package info.gianlucacosta.lambdaprism.logic.basic.formulas

class TestXor extends TestFormula[Xor] {
  "Xor" should "require at least 2 operands" in {
    intercept[IllegalArgumentException] {
      Xor(
        Variable("X")
      )
    }
  }

  "Xor" should "support 2 operands" in {
    Xor(
      Variable("X"),
      Variable("Y")
    )
  }


  "Xor" should "support 3 or more operands" in {
    Xor(
      Variable("X"),
      Variable("Y"),
      Variable("Z")
    )
  }


  override protected def createGroundFormula(): Xor =
    Xor(
      Constant("a"),
      Constant("b")
    )

  override protected def createNonGroundFormula(): Xor =
    Xor(
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
