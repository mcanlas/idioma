import sbt.Keys.*
import sbt.*
import scalafix.sbt.ScalafixPlugin.autoImport.*

object LintingPlugin extends AutoPlugin {
  override def trigger =
    allRequirements

  override val globalSettings =
    addCommandAlias("fmt", "; scalafmtSbt; scalafmtAll") ++
      addCommandAlias("fix", "scalafixAll")

  override val buildSettings =
    List(
      semanticdbEnabled := true,
      semanticdbVersion := scalafixSemanticdb.revision
    )
}
