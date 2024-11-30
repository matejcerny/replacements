import Dependencies.*
import xerial.sbt.Sonatype.sonatypeCentralHost

ThisBuild / scalaVersion := Versions.Scala3
ThisBuild / versionScheme := Some("early-semver")

ThisBuild / organization := "io.github.matejcerny"
ThisBuild / homepage := Some(url("https://github.com/matejcerny/replacements"))
ThisBuild / licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
ThisBuild / developers := List(
  Developer("matejcerny", "Matěj Černý", "cerny.matej@gmail.com", url("https://matejcerny.cz"))
)

ThisBuild / sonatypeCredentialHost := sonatypeCentralHost

publish / skip := true

lazy val root = (project in file("."))
  .settings(
    name := "replacements",
    publish / skip := true,
    publishLocal / skip := true,
    crossScalaVersions := Nil
  )
  .aggregate(core)
  .dependsOn(core)

lazy val core = project
  .in(file("core"))
  .settings(
    name := "replacements-core",
    libraryDependencies ++= Testing
  )
