package test

class Dog : Animal {

    val dog = "Собака"

    override fun eat() {
        println("$dog ест")
    }

    override fun run() {
        println("$dog бежит")
    }

    override fun voice() {
        println("$dog гавкает")
    }
}