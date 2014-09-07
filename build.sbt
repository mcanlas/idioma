lazy val jsonFramework = "org.json4s" %% "json4s-native" % "3.2.10"

lazy val testingFramework = "org.specs2" %% "specs2" % "2.4.1" % "test"

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
