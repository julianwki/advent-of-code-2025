package day3

fun main() {
    var joltage = 0
    input.lines().forEach { bank ->
        val batteries = bank.asSequence().map { it.toString().toInt() }.toList()
        var i = 0
        var j = 1
        IntRange(1, bank.length - 2)
            .forEach {
                if (batteries[it] > batteries[i]) i = it
                if (j == i || batteries[it + 1] > batteries[j]) j = it + 1
            }
        joltage += "${batteries[i]}${batteries[j]}"
            .toInt()
            .also { println("$bank -> $it") }
    }
    println("total: $joltage")
}