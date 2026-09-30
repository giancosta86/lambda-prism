package info.gianlucacosta.lambdaprism.logic.basic.formulas


class TestForAll extends TestFormula[ForAll] {
  "For All" should "be instantiated as a case class" in {
    ForAll(Variable("X"))(
      And(
        Variable("X"),
        Variable("Y")
      )
    )
  }

  override protected def createGroundFormula(): ForAll =
    ForAll(Variable("X"))(
      Constant("a")
    )


  override protected def createNonGroundFormula(): ForAll =
    ForAll(Variable("X"))(
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
