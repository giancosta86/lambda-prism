package info.gianlucacosta.lambdaprism.logic.basic.formulas

class TestExists extends TestFormula[Exists] {
  "Exists" should "be instantiated as a case class" in {
    Exists(Variable("X"))(
      And(
        Variable("X"),
        Variable("Y")
      )
    )
  }


  override protected def createGroundFormula(): Exists =
    Exists(Variable("X"))(
      Constant("a")
    )


  override protected def createNonGroundFormula(): Exists =
    Exists(Variable("X"))(
      CompoundFunctor(
        "f",

        List(
          Constant("a"),
          Variable("X"),
          Constant("b")
        )
      )
    )

}
