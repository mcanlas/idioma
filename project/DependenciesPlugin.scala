import sbt.Keys.*
import sbt.*

import Versions.*

object DependenciesPlugin extends AutoPlugin {
  override def trigger = allRequirements

  object autoImport {
    implicit class DependencyOps(p: Project) {
      val circeVersion =
        "0.14.15"

      val circeYamlVersion =
        "0.16.1"

      def withCats: Project =
        p
          .settings(libraryDependencies += "org.typelevel" %% "cats-core" % catsCore)

      def withYaml: Project =
        p.settings(
          libraryDependencies ++= Seq(
            "io.circe" %% "circe-yaml" % circeYamlVersion
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
          .settings(libraryDependencies += "org.typelevel" %% "cats-effect" % catsEffect)

      def withTesting: Project = {
        p.settings(
          libraryDependencies ++= Seq(
            "org.typelevel" %% "weaver-cats"       % weaver % Test,
            "org.typelevel" %% "weaver-scalacheck" % weaver % Test
          )
        )
      }
    }
  }
}
