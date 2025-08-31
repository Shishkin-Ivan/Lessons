package test

import test.colors.Color
import test.colors.Color.*
import test.transport.Car
import test.transport.Saloon
import test.transport.Truck

data class Person(
    val s: String,
    val age: Int? = null // если так написать, то null можно присвоить
    //val age: Int // если так написать, то null нельзя присвоить
)

fun main() {
    val persons = listOf(
        Person("Alice", age = 29),
        Person("Bob"),
    )
    val oldest = persons.maxBy {
        it.age ?: 0
    }
    println("The oldest is: $oldest")
    println(max(2,3))

    val dog = Dog()
    println(dog.eat())
    println(dog.run())
    println(dog.voice())

    //sayHello()

    val a = 2

    if(a>3) {
        println(1)
    } else if(a>4){
        println(2)
    } else {
        println(3)
    }

    testCar()

    println("----------------------")
    testColors()
    println("----------------------")
    println(getMnemonic(BLUE))
    println("----------------------")
    println(getWarmthFromSensor())
    println("----------------------")
    println(mix(BLUE, YELLOW))

}

// The oldest is: Person(name=Alice, age=29)

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun sayHello() {
    val input = readln()
    val name = if (input.isNotBlank()) {
        input
    } else "Kotlin"
    println("Hello, $name!")
}
//
fun testCar(){
    val truck: Car = Truck()
    truck.gas()
    truck.brake()
    val saloon: Car = Saloon()
    saloon.gas()
    saloon.brake()
}


fun testColors(){
    println(Color.BLUE.rgb)
    // 255
    Color.GREEN.printColor()
    // GREEN = 65280
}

fun getMnemonic(color: Color) =
    when (color) {
        RED -> "Richard"
        ORANGE -> "Of"
        YELLOW -> "York"
        GREEN -> "Gave"
        BLUE -> "Battle"
        INDIGO -> "In"
        VIOLET -> "Vain"
    }

fun measureColor() = ORANGE

fun getWarmthFromSensor(): String {
    val color = measureColor()
    return when(color) {
        RED, ORANGE, YELLOW -> "warm (red = ${color.r})"
        GREEN -> "neutral (green = ${color.g})"
        BLUE, INDIGO, VIOLET -> "cold (blue = ${color.b})"
    }
}

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color")
    }