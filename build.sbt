val commonSettings =
  Nil

lazy val jsonFramework = "org.json4s" %% "json4s-native" % "3.6.7"

lazy val yamlFramework = "org.yaml" % "snakeyaml" % "1.26"

lazy val idioma = (project in file("."))
  .settings(commonSettings: _*)
  .aggregate(grammar, generator, portuguese, spanish, tagalog, arabic, japanese, german, mandarin)

lazy val grammar = project
  .settings(commonSettings: _*)

lazy val generator = project
  .settings(commonSettings: _*)
  .withTesting

lazy val portuguese = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework))
  .withCats
  .withTesting

lazy val spanish = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework))
  .withTesting

lazy val tagalog = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework))
  .withTesting

lazy val arabic = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework))
  .withTesting

lazy val japanese = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework))
  .withTesting

lazy val german = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework))
  .withTesting

lazy val mandarin = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(yamlFramework, jsonFramework))
  .withTesting
