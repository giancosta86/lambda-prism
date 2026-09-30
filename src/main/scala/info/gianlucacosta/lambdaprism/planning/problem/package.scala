package info.gianlucacosta.lambdaprism.planning

package object problem {
  /**
    * Function receiving a planning problem and performing assertions:
    * more precisely, in case of errors, IllegalArgumentException should
    * be thrown (for example, via require() calls)
    */
  type ProblemValidator = (Problem) => Unit
}
