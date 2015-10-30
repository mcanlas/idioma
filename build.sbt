scalaVersion := "2.11.7"

crossScalaVersions := Seq("2.10.5", "2.11.7")

lazy val jsonFramework = "org.json4s" %% "json4s-native" % "3.2.10"

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases" // for specs2

lazy val testingFramework = "org.specs2" %% "specs2-core" % "3.6.5" % "test"

lazy val grammar = project

lazy val generator = project
  .settings(libraryDependencies += testingFramework)

lazy val portuguese = project
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))

lazy val tagalog = project
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))

lazy val arabic = project
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))

lazy val japanese = project
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))
