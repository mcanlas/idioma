val commonSettings = Seq(
  scalaVersion := "2.12.4",
  crossScalaVersions := Seq("2.10.7", "2.11.12", "2.12.4"))

lazy val jsonFramework = "org.json4s" %% "json4s-native" % "3.5.3"

lazy val yamlFramework = "org.yaml" % "snakeyaml" % "1.19"

lazy val testingFramework = "org.specs2" %% "specs2-core" % "3.9.5" % "test"

lazy val hangul = "com.htmlism" %% "hangul-model" % "0.0.1-SNAPSHOT"

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases" // for specs2

lazy val idioma = (project in file("."))
  .settings(commonSettings: _*)
  .aggregate(
    grammar,
    generator,
    portuguese,
    spanish,
    tagalog,
    arabic,
    japanese,
    german,
    korean,
    mandarin)

lazy val grammar = project
  .settings(commonSettings: _*)

lazy val generator = project
  .settings(commonSettings: _*)
  .settings(libraryDependencies += testingFramework)

lazy val portuguese = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))

lazy val spanish = project
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

lazy val german = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(jsonFramework, testingFramework))

lazy val korean = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(hangul, jsonFramework, testingFramework))

lazy val mandarin = project
  .settings(commonSettings: _*)
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(yamlFramework, jsonFramework, testingFramework))
