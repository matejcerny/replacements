/*
 * Copyright 2024 Matěj Černý
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
