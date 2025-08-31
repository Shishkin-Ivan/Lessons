package vararg

fun main(){
    printEven(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // Оператор *, который берет каждый элемент из массива и подставляет в функцию
    printEven(*intArrayOf(1, 2, 3, 4, 5), 6, 7, 8, 9, 10)
}

// Выводим только четные числа
fun printEven(vararg numbers: Int){
    numbers.filter { it % 2 == 0 }.forEach(::println)
}