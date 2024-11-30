package io.github.matejcerny.replacements

import org.specs2.mutable.SpecLike

class ReplacementsTest extends SpecLike:

  "replacements should support concatenation and addition" >> {
    val john = Placeholder("name") -> "John"
    val jane = Placeholder("name") -> "Jane"

    Replacements.Empty ++ Replacements.Empty must beEqualTo(Replacements.Empty)
    Replacements.Empty ++ Replacements(john) must beEqualTo(Replacements(john))
    Replacements(john) ++ Replacements.Empty must beEqualTo(Replacements(john))
    Replacements(john) ++ Replacements(john) must beEqualTo(Replacements(john))
    Replacements(john) ++ Replacements(jane) must beEqualTo(Replacements(john, jane))
    Replacements.Empty + john must beEqualTo(Replacements(john))
  }

  "string should be substituted with variables" >> {
    val string0 = "Hello."
    val string1 = "Hello, {{name}}!"
    val string2 = "Hello, {{name}}! You are {{age}} years old."

    val vars0 = Replacements.Empty
    val vars1 = Replacements(Placeholder("name") -> "John")
    val vars2 = Replacements(Placeholder("name") -> "John", Placeholder("age") -> "25")
    val vars3 = vars1 ++ vars2
    val vars4 = vars1 + (Placeholder("age") -> "25")

    vars0.substitute(string0) must beEqualTo("Hello.")
    vars1.substitute(string0) must beEqualTo("Hello.")
    vars2.substitute(string0) must beEqualTo("Hello.")
    vars3.substitute(string0) must beEqualTo("Hello.")
    vars4.substitute(string0) must beEqualTo("Hello.")

    vars0.substitute(string1) must beEqualTo("Hello, {{name}}!")
    vars1.substitute(string1) must beEqualTo("Hello, John!")
    vars2.substitute(string1) must beEqualTo("Hello, John!")
    vars3.substitute(string1) must beEqualTo("Hello, John!")
    vars4.substitute(string1) must beEqualTo("Hello, John!")

    vars0.substitute(string2) must beEqualTo("Hello, {{name}}! You are {{age}} years old.")
    vars1.substitute(string2) must beEqualTo("Hello, John! You are {{age}} years old.")
    vars2.substitute(string2) must beEqualTo("Hello, John! You are 25 years old.")
    vars3.substitute(string2) must beEqualTo("Hello, John! You are 25 years old.")
    vars4.substitute(string2) must beEqualTo("Hello, John! You are 25 years old.")
  }
