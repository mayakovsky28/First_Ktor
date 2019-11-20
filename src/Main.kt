package com.example

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

data class Course (var identifier: Int = 28, var title: String = "Another course", var complexity: String = "Medium", var isActive: Boolean = false)
val course1 = Course(1, "Learn to read", "Tricky", true)
val course2 = Course(2, "Learn to write")
val course3 = Course(3, "Learn to sing", "Easy", true)

fun main(args: Array<String>) {
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.respondText("Welcome!", ContentType.Text.Plain)
            }
            get("/course/top") {
                call.respondText("HELLO WORLD!")
            }
            get("/course") {
                this@routing.get("1")
                when ()
                is 1 -> call.respondText(course1
                is 2 -> call.respondText(course2)
                is 3 -> call.respondText(course3))
                else -> call.respondText("No course with that ID exists.")
            }
        }
    }
    server.start(wait = true)
}