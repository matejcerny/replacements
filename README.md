# Replacements

![](https://img.shields.io/badge/Scala%203-%23de3423.svg?logo=scala&logoColor=white)
[![Latest version](https://maven-badges.sml.io/sonatype-central/io.github.matejcerny/replacements_3/badge.svg)](https://repo1.maven.org/maven2/io/github/matejcerny/replacements_3)
[![Build Status](https://github.com/matejcerny/replacements/actions/workflows/ci.yml/badge.svg)](https://github.com/matejcerny/replacements/actions/workflows/ci.yml)
[![codecov](https://codecov.io/github/matejcerny/replacements/graph/badge.svg?token=7NFDWHSUN9)](https://codecov.io/github/matejcerny/replacements)

Simple Scala 3 library for replacing placeholders in strings.

## Usage

```scala 3
import io.github.matejcerny.replacements.*

case class MyValues(name: String, age: Int) derives ReplacementValues
val myValues = MyValues("John", 42)

val toBeReplaced = "Hello, {{name}}! You are {{age}} years old."

toBeReplaced.substitute(myValues) // Hello, John! You are 42 years old.
myValues.substitute(toBeReplaced) // Hello, John! You are 42 years old.
```

## Installation

Add the library as a dependency:

```scala
libraryDependencies += "io.github.matejcerny" %% "replacements" % "0.2.0"
```

