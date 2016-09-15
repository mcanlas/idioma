val commonSettings = Seq(
  scalaVersion := "2.11.8",
  crossScalaVersions := Seq("2.10.6", "2.11.8"))

lazy val jsonFramework = "org.json4s" %% "json4s-native" % "3.4.0"

lazy val testingFramework = "org.specs2" %% "specs2-core" % "3.8.5" % "test"

lazy val hangul = "com.htmlism" %% "hangul-model" % "0.0.1-SNAPSHOT"

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases" // for specs2

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .aggregate(
    grammar,
    generator,
    portuguese,
    tagalog,
    arabic,
    japanese,
    korean)

lazy val grammar = project
  .settings(commonSettings: _*)

lazy val generator = project
  .settings(commonSettings: _*)
  .settings(libraryDependencies += testingFramework)

lazy val portuguese = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))

lazy val tagalog = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))

lazy val arabic = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))

lazy val japanese = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))

lazy val korean = project
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= Seq(hangul, jsonFramework, testingFramework))
