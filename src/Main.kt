package com.example

import com.fasterxml.jackson.databind.SerializationFeature
import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.features.ContentNegotiation.Feature.install
import io.ktor.http.*
import io.ktor.jackson.jackson
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.util.*

data class Course (var identifier: Int = 28, var title: String = "Another course", var complexity: String = "Medium", var isActive: Boolean = false)
val course1 = Course(1, "Learn to read", "Tricky", true)
val course2 = Course(2, "Learn to write")
val course3 = Course(3, "Learn to sing", "Easy", true)

data class Snippet(val text: String)

val snippets: MutableList<Snippet> = Collections.synchronizedList(mutableListOf(
    Snippet("hello"),
    Snippet("world")
))

fun main() {
        install() {
            jackson {
                enable(SerializationFeature.INDENT_OUTPUT)
            }
        }
        val server = embeddedServer(Netty, port = 8080) {
            routing {
                get("/") {
                    call.respondText("Welcome!", ContentType.Text.Plain)
                }
                get("/course/top") {
                    call.respondText("HELLO WORLD!")
                }
                get("/course/1") {
                    call.respond(mapOf(course1 to true))
                }
            }
        }
        server.start(wait = true)
    }

fun install(configure: ContentNegotiation.Configuration.() -> Unit) {

}