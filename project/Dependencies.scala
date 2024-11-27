import sbt.*

object Dependencies {

  object Versions {
    val Scala3 = "3.5.2"

    val Specs2 = "5.5.8"
  }

  object Modules {
    val Spec2 = "org.specs2"
  }

  val Testing: Seq[ModuleID] = Seq(
    Modules.Spec2 %% "specs2-core" % Versions.Specs2 % Test,
  )
}
