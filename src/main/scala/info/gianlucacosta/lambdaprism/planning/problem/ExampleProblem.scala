package info.gianlucacosta.lambdaprism.planning.problem

import info.gianlucacosta.lambdaprism.logic.basic.formulas.{CompoundFunctor, Constant, Variable}


/**
  * Example problem - Exam text: 20 February 2014
  */
object ExampleProblem extends Problem(
  List(
    CompoundFunctor(
      "crewAt",

      List(
        Constant("c")
      )
    ),


    CompoundFunctor(
      "robotAt",

      List(
        Constant("b")
      )
    ),


    CompoundFunctor(
      "robotHas",

      List(
        Constant("nothing")
      )
    ),


    CompoundFunctor(
      "crewHas",

      List(
        Constant("nothing")
      )
    ),


    CompoundFunctor(
      "toolsIn",

      List(
        Constant("a")
      )
    ),


    CompoundFunctor(
      "near",

      List(
        Constant("a"),
        Constant("b")
      )
    ),


    CompoundFunctor(
      "near",

      List(
        Constant("b"),
        Constant("a")
      )
    ),


    CompoundFunctor(
      "near",

      List(
        Constant("b"),
        Constant("c")
      )
    ),


    CompoundFunctor(
      "near",

      List(
        Constant("c"),
        Constant("b")
      )
    ),

    CompoundFunctor(
      "broken",

      List(
        Constant("b")
      )
    )
  ),


  List(
    CompoundFunctor(
      "fixed",

      List(
        Constant("b")
      )
    )
  ),


  List(
    MainAction(
      "moveRobot",

      List(
        new Variable("X"),
        new Variable("Y")
      ),

      List(
        CompoundFunctor(
          "near",

          List(
            Variable("X"),
            Variable("Y")
          )
        ),

        CompoundFunctor(
          "robotAt",

          List(
            Variable("X")
          )
        )
      ),

      List(
        CompoundFunctor(
          "robotAt",

          List(
            Variable("Y")
          )
        ),

        ~CompoundFunctor(
          "robotAt",

          List(
            Variable("X")
          )
        )
      )
    ),

    MainAction(
      "moveCrew",

      List(
        new Variable("X"),
        new Variable("Y")
      ),

      List(
        CompoundFunctor(
          "near",

          List(
            Variable("X"),
            Variable("Y")
          )
        ),

        CompoundFunctor(
          "crewAt",

          List(
            Variable("X")
          )
        )
      ),

      List(
        CompoundFunctor(
          "crewAt",

          List(
            Variable("Y")
          )
        ),

        ~CompoundFunctor(
          "crewAt",

          List(
            Variable("X")
          )
        )
      )
    ),

    MainAction(
      "getTools",

      List(
        new Variable("X")
      ),


      List(
        CompoundFunctor(
          "robotAt",

          List(
            Variable("X")
          )
        ),

        CompoundFunctor(
          "robotHas",

          List(
            Constant("nothing")
          )
        ),

        CompoundFunctor(
          "toolsIn",

          List(
            Variable("X")
          )
        )
      ),

      List(
        CompoundFunctor(
          "robotHas",

          List(
            Constant("tools")
          )
        ),

        ~CompoundFunctor(
          "robotHas",

          List(
            Constant("nothing")
          )
        )
      )
    ),

    MainAction(
      "give",

      List(
        new Variable("X"),
        new Variable("Y")
      ),


      List(
        CompoundFunctor(
          "robotAt",

          List(
            Variable("X")
          )
        ),


        CompoundFunctor(
          "crewAt",

          List(
            Variable("X")
          )
        ),

        CompoundFunctor(
          "robotHas",

          List(
            Variable("Y")
          )
        )
      ),


      List(
        CompoundFunctor(
          "robotHas",

          List(
            Constant("nothing")
          )
        ),

        CompoundFunctor(
          "crewHas",

          List(
            Variable("Y")
          )
        ),

        ~CompoundFunctor(
          "robotHas",

          List(
            Variable("Y")
          )
        )
      )
    ),

    MainAction(
      "fix",

      List(
        new Variable("X")
      ),


      List(
        CompoundFunctor(
          "crewAt",

          List(
            Variable("X")
          )
        ),

        CompoundFunctor(
          "broken",

          List(
            Variable("X")
          )
        ),

        CompoundFunctor(
          "crewHas",

          List(
            Constant("tools")
          )
        )
      ),


      List(
        CompoundFunctor(
          "fixed",

          List(
            Variable("X")
          )
        ),

        ~CompoundFunctor(
          "broken",

          List(
            Variable("X")
          )
        )
      )
    )
  )
)
