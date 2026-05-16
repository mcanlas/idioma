import sbt.Keys.*
import sbt.*

import Versions.*

object DependenciesPlugin extends AutoPlugin {
  override def trigger = allRequirements

  object autoImport {
    implicit class DependencyOps(p: Project) {
      def withCats: Project =
        p
          .settings(libraryDependencies += "org.typelevel" %% "cats-core" % catsCore)

      def withYaml: Project =
        p.settings(
          libraryDependencies ++= Seq(
            "io.circe" %% "circe-yaml" % circeYaml
          )
        )

      def withJsonParsing: Project =
        p.settings(
          libraryDependencies ++= Seq(
            "io.circe" %% "circe-generic" % circe,
            "io.circe" %% "circe-parser"  % circe
          )
        )

      def withEffectMonad: Project =
        p
          .settings(libraryDependencies += "org.typelevel" %% "cats-effect" % catsEffect)

      def withTesting: Project =
        p.settings(
          libraryDependencies ++= Seq(
            "org.typelevel" %% "weaver-cats"       % weaver % Test,
            "org.typelevel" %% "weaver-scalacheck" % weaver % Test
          )
        )
    }
  }
}
