package com.example.spingbootkotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/greeting")
class Controller {

    @GetMapping
    fun index():
            List<Greeting> = listOf(
        Greeting(1, "Hello!"),
        Greeting(2, "Bonjour!"),
        Greeting(3, "Guten Tag!"),
    )

    @GetMapping("/v1")
    fun hello(): String {
        val test = "It's a test from V1!"
        return test
    }

    @GetMapping("/v2")
    fun hello2(): String = "It's a test from V2!"

    @GetMapping("/v3")
    fun getId(): Int = Greeting(1, "Hello!").id
}