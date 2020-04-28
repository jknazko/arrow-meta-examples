package io.arrowkt.example

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.invoke
import arrow.meta.quotes.Transform
import arrow.meta.quotes.namedFunction

val Meta.helloWorld: CliPlugin
  get() =
    "Hello World" {
      meta(
        namedFunction({ name == "helloWorld" }) { c ->
            Transform.newSources(
                """
                  package arrow
                  //metadebug
                  class ${name}_Generated {
                    fun sayHi() = println("Hi!")
                  }
                """.file("${name}_Generated")
            )
//          Transform.replace(
//            replacing = c,
//            newDeclaration =
//            """|fun helloWorld(): Unit =
//               |  println("Hello ΛRROW Meta!")
//               |""".function.syntheticScope
//          )
        }
      )
    }