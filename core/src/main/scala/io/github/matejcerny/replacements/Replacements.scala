package io.github.matejcerny.replacements

import scala.annotation.targetName

opaque type Replacements = Map[Placeholder, String]

object Replacements:
  val Empty: Replacements = Map.empty

  def apply(replacements: (Placeholder, String)*): Replacements = replacements.toMap
  def apply(replacements: Map[Placeholder, String]): Replacements = replacements

  extension (replacements: Replacements)
    def reveal: Map[String, String] = replacements.map((p, v) => p.replacement -> v)

    @targetName("concat")
    def ++(other: Replacements): Replacements = replacements ++ other

    @targetName("add")
    def +(other: (Placeholder, String)): Replacements = replacements + other

    def substitute(input: String): String =
      if replacements.isEmpty then input
      else
        val (regex, stringReplacements) = replacements.foldLeft(("", Map.empty[String, String])) {
          case ((regex, replacements), (placeholder, value)) =>
            val escapedReplacement = placeholder.replacement.replaceAll("\\{", "\\\\{").replaceAll("\\}", "\\\\}")
            (
              s"$regex|$escapedReplacement",
              replacements + (placeholder.replacement -> value)
            )
        }
        regex.tail.r.replaceAllIn(input, m => stringReplacements(m.matched))
