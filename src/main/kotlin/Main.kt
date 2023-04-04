private fun readStr() = readln() // string line

private fun readInt() = readStr().toInt() // single int

private fun readDouble() = readStr().toDouble() // single double

private fun readStrings() = readStr().split(" ") // list of strings

private fun readInts() = readStrings().map { it.toInt() } // list of ints

private fun readLongs() = readStrings().map { it.toLong() } // list of ints

private fun readDoubles() = readStrings().map { it.toDouble() } // list of doubles

private fun readArray() = readLongs().toTypedArray()

private fun <T> printArray(array: Array<T>, separator: String = " ") {
    println(array.joinToString(separator)) // each element of array/list of a separate line
}


fun main() {
    val n = readInt()
    val h1 = readArray()
    val h2 = readArray()
    val r1 = LongArray(n) { 0 }
    val r2 = LongArray(n) { 0 }

    r1[0] = h1[0] // взяли из первого ряда
    r2[0] = h2[0] // взяли из второго ряда

    for (i in 1 until n) {
        r1[i] = maxOf(r1[i - 1], r2[i - 1] + h1[i])
        r2[i] = maxOf(r2[i - 1], r1[i - 1] + h2[i])
    }

    val ans = maxOf(r1[n - 1], r2[n - 1])
    print(ans)
}
