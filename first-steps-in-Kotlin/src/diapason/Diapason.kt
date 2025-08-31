package diapason

// Диапазоны
fun main(){
    // Если ли 5 в диапазоне от 1 до 10?
    println( 5 in 1..10 ) // true

    // Цикл из диапазона чисел
    for( i in 1..10 ){
        print("$i ") //1 2 3 4 5 6 7 8 9 10
    }

    // Без включения последнего числа
    println()
    for( i in 1 until 10 ){
        print("$i ") //1 2 3 4 5 6 7 8 9
    }
    println()

    // Диапазон от большего к меньшему
    for( i in 10 downTo 1 ){
        print("$i ") // 10 9 8 7 6 5 4 3 2 1
    }
    println()

    // Диапазон чисел с разницей 10 шагов между числами
    for( i in 0..100 step 10){
        print("$i ") // 0 10 20 30 40 50 60 70 80 90 100
    }

    println("1 + 1 = ${sum(1, 1)}")

    val list = getList(y = 2, z = 3, x = 1)
    println(list)

    println(getDefaultArguments(1))
}

fun sum(a: Int, b: Int) = a + b

fun getList(x: Int, y: Int, z: Int) : List<Int> {
    return listOf(x, y, z)
}

fun getDefaultArguments(a: Int = 1, b: Int = 4) = a + b
