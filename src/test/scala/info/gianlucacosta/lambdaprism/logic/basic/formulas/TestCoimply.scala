package info.gianlucacosta.lambdaprism.logic.basic.formulas

class TestCoimply extends TestFormula[Coimply] {
  override protected def createGroundFormula(): Coimply =
    Coimply(
      Constant("a"),
      Constant("b")
    )

  override protected def createNonGroundFormula(): Coimply =
    Coimply(
      Constant("a"),
      Variable("B")
    )
}
