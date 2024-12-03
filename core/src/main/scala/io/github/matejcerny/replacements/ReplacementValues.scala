package io.github.matejcerny.replacements

trait ReplacementValues[T]:
  def replacements(t: T): Replacements

object ReplacementValues:
  extension [T](t: T)(using rv: ReplacementValues[T])
    def replacements: Replacements = rv.replacements(t)
    def substitute(string: String): String = rv.replacements(t).substitute(string)

  extension [T: ReplacementValues](string: String) def substitute(t: T): String = t.substitute(string)

  inline def derived[T <: Product]: ReplacementValues[T] =
    (t: T) =>
      Replacements(
        t.productElementNames
          .zip(t.productIterator)
          .map((name, value) => Placeholder(name) -> value.toString)
          .toMap
      )
