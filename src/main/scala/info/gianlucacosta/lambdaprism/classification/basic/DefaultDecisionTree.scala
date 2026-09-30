package info.gianlucacosta.lambdaprism.classification.basic


/**
  * Internal DecisionTree implementation
  *
  * @param problem
  * @param attribute
  * @param leaves
  */
private case class DefaultDecisionTree(
                                        problem: ClassificationProblem,
                                        attribute: Attribute,
                                        leaves: Map[Value, DecisionTreeLeaf]
                                      ) extends DecisionTree {

  override def classify(attributeValue: Value): Map[Value, Double] = {
    attributeValue match {
      case ClassificationProblem.UnknownValue =>
        problem.outputValues.map((outputValue) => {
          val weightedOutputProbability: Double =
            leaves.foldLeft(0.0) {
              case (cumulatedOutputProbability, (_, leaf)) =>
                cumulatedOutputProbability +
                  leaf.weight * leaf.getOutputProbability(outputValue)
            }

          outputValue -> weightedOutputProbability
        })
          .toMap


      case value: Value =>
        val leafOption =
          leaves.get(value)

        leafOption match {
          case Some(leaf) =>
            problem.outputValues.map((outputValue) =>
              outputValue ->
                leaf.getOutputProbability(outputValue)
            ).toMap

          case None =>
            problem.outputValues.map((outputValue) =>
              outputValue -> 0.0
            ).toMap
        }

    }
  }
}
