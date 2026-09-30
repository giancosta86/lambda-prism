package info.gianlucacosta.lambdaprism.classification

package object basic {
  /**
    * Attribute of an item
    */
  type Attribute =
  String

  /**
    * The value of an attribute, for an item
    */
  type Value =
  String

  /**
    * Tabular description of an item
    */
  type Row =
  List[Value]

  /**
    * Tabular description of an item set
    */
  type Table =
  List[Row]
}
