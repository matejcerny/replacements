object Options {

  val scalacOptions3: Seq[String] = Seq(
    "-explain", // Explain type errors in more detail.
    "-language:existentials", // Existential types (besides wildcard types) can be written and inferred.
    "-language:higherKinds", // Allow higher-kinded types.
    "-language:implicitConversions", // Allow definition of implicit functions called views.
    "-language:postfixOps" // Allow postfix operator notation, such as 1 to 10 toList (not recommended).
  )

}
