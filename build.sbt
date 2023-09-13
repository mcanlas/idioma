val commonSettings =
  Nil

lazy val jsonFramework = "org.json4s" %% "json4s-native" % "3.6.7"

lazy val yamlFramework = "org.yaml" % "snakeyaml" % "1.26"

lazy val testingFramework = "org.specs2" %% "specs2-core" % "4.10.6" % "test"

lazy val idioma = (project in file("."))
  .settings(commonSettings: _*)
  .aggregate(grammar, generator, portuguese, spanish, tagalog, arabic, japanese, german, mandarin)

lazy val grammar = project
  .settings(commonSettings: _*)

lazy val generator = project
  .settings(commonSettings: _*)
  .settings(libraryDependencies += testingFramework)
  .withTesting

lazy val portuguese = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))
  .withTesting

lazy val spanish = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))
  .withTesting

lazy val tagalog = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))
  .withTesting

lazy val arabic = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))
  .withTesting

lazy val japanese = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))
  .withTesting

lazy val german = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))
  .withTesting

lazy val mandarin = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(yamlFramework, jsonFramework, testingFramework))
  .withTesting
