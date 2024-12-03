package io.github.matejcerny.replacements

import org.specs2.mutable.SpecLike

class ReplacementValuesTest extends SpecLike:

  case class MyValues(name: String, age: Int) derives ReplacementValues

  private val myValues = MyValues("John", 25)

  "Replacements should be revealed" >> {
    myValues.replacements.reveal must beEqualTo(Map("{{name}}" -> "John", "{{age}}" -> "25"))
  }

  "String with placeholders should be replaced with values from a case class" >> {
    val toBeReplaced = "Hello, {{name}}! You are {{age}} years old."
    val replaced = "Hello, John! You are 25 years old."

    myValues.replacements.substitute(toBeReplaced) must beEqualTo(replaced)
    myValues.substitute(toBeReplaced) must beEqualTo(replaced)
    toBeReplaced.substitute(myValues) must beEqualTo(replaced)
  }
