val jsonFramework = "org.json4s" %% "json4s-native" % "3.2.9"

val testingFramework = "org.specs2" %% "specs2" % "2.3.12" % "test"

val grammar = project

val iteration = project
  .settings(libraryDependencies += testingFramework)

val portuguese = project
  .dependsOn(grammar, iteration)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))
