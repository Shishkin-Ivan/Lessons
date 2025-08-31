package collerctions

fun main() {
    val binaryReps = mutableMapOf<Char, String>()
    for (char in 'A'..'C') {
        val binary = char.code.toString(radix = 2)
        binaryReps[char] = binary
    }

    binaryReps['B'] = "Тут находится - B"

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}