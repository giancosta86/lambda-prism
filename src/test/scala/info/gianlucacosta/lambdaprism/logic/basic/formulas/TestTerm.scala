package info.gianlucacosta.lambdaprism.logic.basic.formulas

import org.scalatest.{FlatSpec, Matchers}


class TestTerm extends FlatSpec with Matchers {
  "Replacing a variable in a constant" should "do nothing" in {
    Constant("a").replaceVariables(
      Map(
        Variable("Gamma") -> Constant("omega")
      )
    ) should be(Constant("a"))
  }


  "Replacing a variable with a constant" should "work" in {
    Variable("A").replaceVariables(
      Map(
        Variable("A") -> Constant("a")
      )
    ) should be(Constant("a"))
  }


  "Replacing a variable with another variable" should "work" in {
    Variable("A").replaceVariables(
      Map(
        Variable("A") -> Variable("B")
      )
    ) should be(Variable("B"))
  }


  "Replacing a variable with a constant in a compound functor" should "replace every instance of the variable" in {

    CompoundFunctor(
      "f",
      List(
        Constant("a"),
        Variable("Gamma"),
        Variable("Beta"),
        Variable("Gamma"),
        Constant("delta")
      )
    ).replaceVariables(
      Map(
        Variable("Gamma") -> Constant("omega")
      )
    ) should be(

      CompoundFunctor(
        "f",
        List(
          Constant("a"),
          Constant("omega"),
          Variable("Beta"),
          Constant("omega"),
          Constant("delta")
        )
      )
    )
  }


  "Replacing a variable in a negative literal" should "keep the negative sign" in {
    (~CompoundFunctor(
      "f",
      List(
        Constant("a"),
        Variable("Gamma"),
        Variable("Beta"),
        Variable("Gamma"),
        Constant("delta")
      ))
      ).replaceVariables(
      Map(
        Variable("Gamma") -> Constant("omega")
      )
    ) should be(
      ~CompoundFunctor(
        "f",
        List(
          Constant("a"),
          Constant("omega"),
          Variable("Beta"),
          Constant("omega"),
          Constant("delta")
        )
      )
    )
  }


  "Multiple variables" should "be replaced at once" in {
    CompoundFunctor(
      "f",
      List(
        Constant("a"),
        Variable("Gamma"),
        Variable("Beta"),
        Variable("Gamma"),
        Constant("delta")
      )
    ).replaceVariables(
      Map(
        Variable("Gamma") -> Constant("omega"),
        Variable("Beta") -> Constant("tau")
      )
    ) should be(
      CompoundFunctor(
        "f",
        List(
          Constant("a"),
          Constant("omega"),
          Constant("tau"),
          Constant("omega"),
          Constant("delta")
        )
      )
    )
  }


  "Swapping variables" should "work" in {
    CompoundFunctor(
      "f",
      List(
        Variable("X"),
        Variable("Y")
      )
    ).replaceVariables(
      Map(
        Variable("X") -> Variable("Y"),
        Variable("Y") -> Variable("X")
      )
    ) should be(
      CompoundFunctor(
        "f",
        List(
          Variable("Y"),
          Variable("X")
        )
      )
    )
  }


  "Swapping variables with names of temp variables" should "work" in {
    CompoundFunctor(
      "f",
      List(
        Variable("X"),
        Variable("X_")
      )
    ).replaceVariables(
      Map(
        Variable("X") -> Variable("X_"),
        Variable("X_") -> Variable("X")
      )
    ) should be(
      CompoundFunctor(
        "f",
        List(
          Variable("X_"),
          Variable("X")
        )
      )
    )
  }
}
