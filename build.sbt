lazy val jsonFramework = "org.json4s" %% "json4s-native" % "3.2.9"

lazy val testingFramework = "org.specs2" %% "specs2" % "2.3.12" % "test"

lazy val portuguese = project
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))
