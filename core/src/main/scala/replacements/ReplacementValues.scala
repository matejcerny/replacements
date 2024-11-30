package replacements

trait ReplacementValues[T]:
  def replacements(t: T): Replacements

object ReplacementValues:
  extension [T](t: T)(using r: ReplacementValues[T]) def replacements: Replacements = r.replacements(t)
  extension [T: ReplacementValues](string: String) def substitute(t: T): String = t.replacements.substitute(string)

  inline def derived[T <: Product]: ReplacementValues[T] =
    (t: T) =>
      Replacements(
        t.productElementNames
          .zip(t.productIterator)
          .map((name, value) => Placeholder(name) -> value.toString)
          .toMap
      )
