package info.gianlucacosta.lambdaprism.classification.basic

/**
  * Default DecisionTreeLeaf implementation
  *
  * @param problem
  * @param attributeValue
  * @param weight
  * @param probabilisticOutputCountMap
  */
private case class DefaultDecisionTreeLeaf(
                                            problem: ClassificationProblem,
                                            attributeValue: Value,
                                            weight: Double,
                                            probabilisticOutputCountMap: Map[Value, Double]
                                          ) extends DecisionTreeLeaf {
  override val outputLabel: Value =
    probabilisticOutputCountMap
      .toList
      .sortBy(_._2)
      .last
      ._1


  override def getProbabilisticCount(outputValue: Value): Double =
    probabilisticOutputCountMap.getOrElse(outputValue, 0)


  override val totalProbabilisticCount: Double =
    probabilisticOutputCountMap
      .foldLeft(0.0) {
        case (cumulatedTotalProbabilisticCount, (_, probabilisticCount)) =>
          cumulatedTotalProbabilisticCount + probabilisticCount
      }


  override val probabilisticCorrectCount: Double =
    probabilisticOutputCountMap(outputLabel)


  override val probabilisticWrongCount: Double =
    totalProbabilisticCount - probabilisticCorrectCount


  override def getOutputProbability(outputValue: Value): Double =
    getProbabilisticCount(outputValue) / totalProbabilisticCount


  override val toString: Value = {
    val probabilisticOutputCountString =
      problem
        .outputValues
        .toList
        .sorted
        .map(outputValue =>
          s"Probabilistic #(${problem.outputAttribute} = ${outputValue}) = ${getProbabilisticCount(outputValue)}"
        )
        .mkString("\n")

    s"${probabilisticOutputCountString}\n\n" +
      s"\n${problem.outputAttribute} = ${outputLabel}\n\n" +
      s"Probabilistic correct # = ${probabilisticCorrectCount}\n" +
      s"Probabilistic wrong # = ${probabilisticWrongCount}\n" +
      s"Total probabilistic # = ${totalProbabilisticCount}"
  }
}
