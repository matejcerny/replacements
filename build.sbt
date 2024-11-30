import Dependencies.*

ThisBuild / scalaVersion := Versions.Scala3

inThisBuild(List(
  organization := "com.github.matejcerny",
  homepage := Some(url("https://github.com/matejcerny/replacements")),
  licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  developers := List(
    Developer(
      "matejcerny",
      "Matěj Černý",
      "cerny.matej@gmail.com",
      url("https://matejcerny.cz")
    )
  )
))

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
