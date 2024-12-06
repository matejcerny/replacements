import Dependencies.*

ThisBuild / tlBaseVersion := "0.1"

ThisBuild / organization := "io.github.matejcerny"
ThisBuild / organizationName := "Matěj Černý"

ThisBuild / startYear := Some(2024)

ThisBuild / scalaVersion := Versions.Scala3
ThisBuild / versionScheme := Some("early-semver")

ThisBuild / homepage := Some(url("https://github.com/matejcerny/replacements"))
ThisBuild / licenses := Seq(License.Apache2)
ThisBuild / developers := List(tlGitHubDev("matejcerny", "Matěj Černý"))

lazy val replacements = tlCrossRootProject.aggregate(core)

lazy val core = crossProject(JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("core"))
  .settings(
    name := "replacements",
    libraryDependencies ++= Testing,
    scalacOptions ++= Options.scalacOptions3
  )
