object Options {

  val scalacOptions3: Seq[String] = Seq(
    "-deprecation", // Emit warning and location for usages of deprecated APIs.
    "-encoding", "utf-8", // Specify character encoding used by source files.
    "-explain", // Explain type errors in more detail.
    "-feature", // Emit warning and location for usages of features that should be imported explicitly.
    "-language:existentials", // Existential types (besides wildcard types) can be written and inferred.
    "-language:higherKinds", // Allow higher-kinded types.
    "-language:implicitConversions", // Allow definition of implicit functions called views.
    "-language:postfixOps", // Allow postfix operator notation, such as 1 to 10 toList (not recommended).
    "-unchecked", // Enable additional warnings where generated code depends on assumptions.
    "-Wunused:imports" // Warn if an import selector is not referenced.
  )

}
