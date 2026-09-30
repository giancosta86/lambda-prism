package info.gianlucacosta.lambdaprism.classification.basic

import info.gianlucacosta.helios.mathutils.Maths

object Entropy {
  /**
    * Computes the entropy of the given item set,
    * assuming the output attribute is the rightmost one.
    *
    * @param valueTable
    * @return
    * <ol>
    * <li>0, if all the items have the same output value</li>
    * <li>1, if all the output values are distributed on the same # of instances</li>
    * <li>the result of the floating-point formula, otherwise</li>
    * </ol>
    */
  def compute(valueTable: Table): Double = {
    val totalRowCount =
      valueTable.length

    val rowsGroupedByOutputAttribute =
      valueTable
        .groupBy(row => row.last)


    if (rowsGroupedByOutputAttribute.size == 1)
      0
    else {
      val allGroupsHaveTheSameSize =
        rowsGroupedByOutputAttribute
          .map(_._2.size)
          .toSet
          .size == 1

      if (allGroupsHaveTheSameSize)
        1
      else
        rowsGroupedByOutputAttribute
          .foldLeft(0.0)((cumulatedEntropy, outputGroup) => {
            val groupRows =
              outputGroup._2

            val groupWeight =
              groupRows.length.toDouble / totalRowCount

            cumulatedEntropy - groupWeight * Maths.log(2)(groupWeight)
          })
    }
  }
}
