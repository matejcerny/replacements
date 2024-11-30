package cz.matejcerny.replacements

opaque type Placeholder = String

object Placeholder:
  def apply(underlying: String): Placeholder = underlying

  extension (placeholder: Placeholder) def replacement: String = s"{{$placeholder}}"
