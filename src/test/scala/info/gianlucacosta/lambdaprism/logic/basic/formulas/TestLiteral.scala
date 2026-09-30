package info.gianlucacosta.lambdaprism.logic.basic.formulas

class TestLiteral extends TestFormula[Literal] {
  "A constant" should "be positive by default" in {
    Constant("a").isPositive should be(true)
  }


  "A variable" should "be positive by default" in {
    Variable("A").isPositive should be(true)
  }


  "A compound functor" should "be positive by default" in {
    CompoundFunctor(
      "f",
      List(
        Constant("a"),
        Variable("B")
      )
    ).isPositive should be(true)
  }



  "Inverting a positive literal" should "return a negative literal" in {
    (~Constant("a")).isPositive should be(false)
    ~Constant("a") should not be Constant("a")
  }


  "Inverting a negative literal" should "return a positive literal" in {
    (~(~Variable("A"))) should be(Variable("A"))
  }


  override protected def createGroundFormula(): Literal =
    ~Constant("a")


  override protected def createNonGroundFormula(): Literal =
    CompoundFunctor(
      "f",

      List(
        Constant("a"),
        Variable("X"),
        Constant("b")
      )
    )
}
