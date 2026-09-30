package info.gianlucacosta.lambdaprism.classification.basic

import info.gianlucacosta.helios.fx.dialogs.{Alerts, InputDialogs}

import scalafx.scene.control.Alert.AlertType

/**
  * Dialog asking input for ClassificationProblem
  */
object ClassificationProblemDialog {
  /**
    * Asks the user for the description of a ClassificationProblem.
    *
    * @param initialProblemOption The problem initially shown; if None, an example
    *                             problem will be shown instead
    * @return A valid ClassificationProblem instance,
    *         or None if the user canceled the dialog
    */
  def askForProblem(
                     initialProblemOption: Option[ClassificationProblem]
                   ): Option[ClassificationProblem] = {

    val actualInitialProblem =
      initialProblemOption
        .getOrElse(ExampleProblem)


    val headerText =
      if (initialProblemOption.isEmpty)
        "New classification problem..."
      else
        "Edit classification problem..."


    var inputProblem: Option[ClassificationProblem] =
      None


    val dialogResult =
      InputDialogs.askForText(
        "Please, enter a description of the problem:",

        actualInitialProblem.toString,

        headerText,

        (inputText) => {
          try {
            inputProblem =
              Some(
                ClassificationProblemParser.parse(inputText)
              )
            true
          } catch {
            case ex: IllegalArgumentException =>
              Alerts.showException(ex, alertType = AlertType.Warning)
              false
          }
        },

        "-fx-font-family: monospace; -fx-font-size: 16px;"
      )


    dialogResult.flatMap(_ =>
      inputProblem
    )
  }
}
