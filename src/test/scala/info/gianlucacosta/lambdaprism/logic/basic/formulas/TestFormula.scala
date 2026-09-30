package info.gianlucacosta.lambdaprism.logic.basic.formulas

import org.scalatest.{FlatSpec, Matchers}

abstract class TestFormula[T <: Formula] extends FlatSpec with Matchers {

  "Ground formula" should "be detected" in {
    val groundFormula = createGroundFormula()

    groundFormula.isGround should be(true)
  }


  "Non-ground formula" should "be detected" in {
    val nonGroundFormula = createNonGroundFormula()

    nonGroundFormula.isGround should be(false)
  }


  protected def createGroundFormula(): T

  protected def createNonGroundFormula(): T
}
