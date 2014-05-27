lazy val jsonFramework = "org.json4s" %% "json4s-native" % "3.2.9"

lazy val grammar = project
  .settings(libraryDependencies += jsonFramework)
