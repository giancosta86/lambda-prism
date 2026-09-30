package info.gianlucacosta.lambdaprism.classification.basic

/**
  * Exam - 8 January 2009
  */
object ExampleProblem extends ClassificationProblem(
  List(
    "Temperature",
    "Humidity",
    "Class"
  ),

  List(
    List("High", "High", "Pos"),
    List("High", "Low", "Neg"),
    List("Low", "Medium", "Pos"),
    List("Low", "High", "Pos"),
    List("High", "Medium", "Neg"),
    List("Low", "Low", "Pos"),
    List("Low", "Low", "Neg"),
    List("?", "Low", "Neg"),
    List("High", "High", "Pos"),
    List("High", "High", "Neg"),
    List("Low", "Low", "Pos"),
    List("High", "High", "Neg"),
    List("?", "Medium", "Pos"),
    List("Low", "Medium", "Pos"),
    List("High", "Medium", "Neg"),
    List("Low", "Low", "Pos"),
    List("?", "Low", "Pos")
  )
)
