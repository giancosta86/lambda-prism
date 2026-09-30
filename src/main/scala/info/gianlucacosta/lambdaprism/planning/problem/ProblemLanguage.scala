package info.gianlucacosta.lambdaprism.planning.problem

/**
  * Details about the language describing planning problems
  */
object ProblemLanguage {
  val ReservedActionNames = Set(
    StartAction.Name,
    GoalAction.Name
  )

  val CommentPattern =
    raw"//[^\n]*" + "|" +
      raw"#[^\n]*" + "|" +
      raw"(?s)/\*.*?(\*/|\Z)"

  val StartKeyword = "START"
  val GoalKeyword = "GOAL"

  val ActionKeyword = "ACTION"
  val PreconditionsKeyword = "PRE"
  val EffectsKeyword = "POST"

  val Keywords = List(
    StartKeyword,
    GoalKeyword,

    ActionKeyword,
    PreconditionsKeyword,
    EffectsKeyword
  )
}
