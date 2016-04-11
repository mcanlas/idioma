import sbt._
import Keys._

object IdiomaBuild extends Build {
  lazy val jsonFramework = "org.json4s" %% "json4s-native" % "3.3.0"

  lazy val testingFramework = "org.specs2" %% "specs2-core" % "3.7.3" % "test"

  lazy val hangul = "com.htmlism" %% "hangul-model" % "0.0.1-SNAPSHOT"

  val twoEleven = "2.11.8"

  resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases" // for specs2

  scalaVersion := twoEleven

  lazy val korean = Project("korean", file("korean"),
    settings = Seq(
      scalaVersion := twoEleven,
      libraryDependencies ++= Seq(hangul, jsonFramework, testingFramework)))
}
