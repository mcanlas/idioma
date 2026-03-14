import sbt.Keys.*
import sbt.*

object DependenciesPlugin extends AutoPlugin {
  override def trigger = allRequirements

  object autoImport {
    implicit class DependencyOps(p: Project) {
      val circeVersion =
        "0.14.10"

      def withCats: Project =
        p
          .settings(libraryDependencies += "org.typelevel" %% "cats-core" % "2.13.0")

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
          .settings(libraryDependencies += "org.typelevel" %% "cats-effect" % "3.7.0")

      def withTesting: Project = {
        val weaverVersion =
          "0.8.4"

        p.settings(
          libraryDependencies ++= Seq(
            "com.disneystreaming" %% "weaver-cats"       % weaverVersion % Test,
            "com.disneystreaming" %% "weaver-scalacheck" % weaverVersion % Test
          )
        )
      }
    }
  }
}
