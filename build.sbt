import Dependencies.*

ThisBuild / organization := "cz.matejcerny"
ThisBuild / scalaVersion := Versions.Scala3

lazy val root = (project in file("."))
  .settings(
    name := "replacements",
    publish / skip := true,
    publishLocal / skip := true,
    Compile / coverageEnabled := false,
    crossScalaVersions := Nil
  )

lazy val core = project
  .in(file("core"))
  .settings(
    name := "core",
    libraryDependencies ++= Testing,
  )
