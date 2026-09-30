package info.gianlucacosta.lambdaprism.classification.basic

/**
  * A basic decision tree, having just one leaf level
  */
trait DecisionTree {

  /**
    * The original problem
    *
    * @return
    */
  def problem: ClassificationProblem


  /**
    * The attribute on which the tree is based
    *
    * @return
    */
  def attribute: Attribute

  /**
    * The map <i>attribute value - tree leaf</i>
    *
    * @return
    */
  def leaves: Map[Value, DecisionTreeLeaf]


  /**
    * Classifies an instance having the given attribute value - thus returning
    * a map telling the probability associated with each output value.
    *
    * @param attributeValue The attribute value. It can also be the unknown-value placeholder
    * @return The map of probabilities
    */
  def classify(attributeValue: Value): Map[Value, Double]
}
