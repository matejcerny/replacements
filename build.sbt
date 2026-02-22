val commonSettings = Seq(
  sbtConfigFile := (ThisBuild / baseDirectory).value / "build.conf"
)

lazy val jvm = project.in(file("jvm"))
  .settings(commonSettings)

lazy val js = project.in(file("js"))
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)

lazy val native = project.in(file("native"))
  .enablePlugins(ScalaNativePlugin)
  .settings(commonSettings)
