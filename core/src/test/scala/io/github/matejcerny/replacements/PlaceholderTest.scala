package io.github.matejcerny.replacements

import org.specs2.mutable.SpecLike

class PlaceholderTest extends SpecLike:

  "Replacement should be created" >> {
    Placeholder("test").replacement must beEqualTo("{{test}}")
  }
