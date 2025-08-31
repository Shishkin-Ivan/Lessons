package com.example.spingbootkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpingBootKotlinApplication

fun main(args: Array<String>) {
    runApplication<SpingBootKotlinApplication>(*args)
}
