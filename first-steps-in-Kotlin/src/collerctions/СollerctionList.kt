package collerctions

fun main() {
    val list = listOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}
// 0: 10
// 1: 11
// 2: 1001
