package day3

fun main() {
    var joltage = 0L
    input.lines().forEach { bank ->
        val batteries = bank.asSequence().map { it.toString().toInt() }.toList()
        val digits = 12
        val idx = IntRange(0, digits - 1).toMutableList()
        IntRange(1, bank.length - digits)
            .forEach {
                if (batteries[it] > batteries[idx[0]]) idx[0] = it
                IntRange(1, digits - 1).forEach { j ->
                    if (idx[j] == idx[j - 1] || batteries[it + j] > batteries[idx[j]]) idx[j] = it + j
                }
            }
        joltage += IntRange(0, digits - 1)
            .joinToString("") { "${batteries[idx[it]]}" }
            .toLong()
            .also { println("$bank -> $it") }
    }
    println("total: $joltage")
}