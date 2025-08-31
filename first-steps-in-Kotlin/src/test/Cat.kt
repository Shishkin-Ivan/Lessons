package test

class Cat : Animal {

    val cat = "Кошка"

    override fun eat() {
        println("$cat ест")
    }

    override fun run() {
        println("$cat бежит")
    }

    override fun voice() {
        println("$cat мяукает")
    }
}