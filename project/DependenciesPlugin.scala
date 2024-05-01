import sbt.Keys.*
import sbt.*

object DependenciesPlugin extends AutoPlugin {
  override def trigger = allRequirements

  object autoImport {
    implicit class DependencyOps(p: Project) {
      val circeVersion =
        "0.14.7"

      def withYaml: Project =
        p.settings(
          libraryDependencies ++= Seq(
            "io.circe" %% "circe-yaml" % "0.15.1"
          )
        )

      def withJsonParsing: Project =
        p.settings(
          libraryDependencies ++= Seq(
            "io.circe" %% "circe-generic" % circeVersion,
            "io.circe" %% "circe-parser"  % circeVersion
          )
        )

      def withEffectMonad: Project =
        p
          .settings(libraryDependencies += "org.typelevel" %% "cats-effect" % "3.5.4")
    }
  }
}
