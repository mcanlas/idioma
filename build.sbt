lazy val jsonFramework = "org.json4s" %% "json4s-native" % "4.0.6"

lazy val yamlFramework = "org.yaml" % "snakeyaml" % "1.26"

lazy val idioma = (project in file("."))
  .aggregate(
    `data-loader`,
    grammar,
    generator,
    portuguese,
    spanish,
    tagalog,
    arabic,
    japanese,
    german,
    korean,
    mandarin
  )

lazy val `data-loader` = project
  .withEffectMonad
  .withJsonParsing
  .withYaml

lazy val grammar = project

lazy val generator = project.withTesting

lazy val portuguese = project
  .dependsOn(grammar, generator, `data-loader`)
  .settings(libraryDependencies ++= Seq(jsonFramework))
  .withCats
  .withTesting

lazy val spanish = project
  .dependsOn(grammar, generator, `data-loader`)
  .withTesting

lazy val tagalog = project
  .dependsOn(grammar, generator, `data-loader`)
  .withTesting

lazy val arabic = project
  .dependsOn(grammar, generator)
  .withTesting

lazy val japanese = project
  .dependsOn(grammar, generator)
  .withTesting

lazy val german = project
  .dependsOn(grammar, generator)
  .withTesting

lazy val korean = project
  .dependsOn(grammar, generator)
  .withGitHubPackagesCredentials
  .withResolver("hangul")
  .settings(libraryDependencies ++= Seq(jsonFramework))
  .settings(libraryDependencies += "com.htmlism" %% "hangul-model" % "322-485a82b9")
  .withTesting

lazy val mandarin = project
  .dependsOn(grammar, generator)
  .settings(libraryDependencies ++= Seq(yamlFramework))
  .withTesting
