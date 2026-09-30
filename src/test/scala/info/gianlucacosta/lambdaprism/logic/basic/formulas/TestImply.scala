package info.gianlucacosta.lambdaprism.logic.basic.formulas

class TestImply extends TestFormula[Imply] {
  override protected def createGroundFormula(): Imply =
    Imply(
      Constant("a"),

      Constant("b")
    )

  override protected def createNonGroundFormula(): Imply =
    Imply(
      Constant("a"),

      Variable("B")
    )
}
