# Replacements

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
