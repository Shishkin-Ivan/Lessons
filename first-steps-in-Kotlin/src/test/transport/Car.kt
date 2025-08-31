package test.transport

interface Car{
    fun gas()
    fun brake()
}

class Truck: Car{
    override fun gas(){
        println("$this gas")
    }

    override fun brake(){
        println("$this brake")
    }

    override fun toString(): String {
        return this.javaClass.simpleName
    }
}

class Saloon: Car{
    override fun gas(){
        println("$this gas")
    }

    override fun brake(){
        println("$this brake")
    }

    override fun toString(): String {
        return this.javaClass.simpleName
    }
}