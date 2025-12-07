package day2

fun main() {
    var count = 0L
    input.split(',')
        .map { it.split('-') }
        .map { LongRange(it[0].toLong(), it[1].toLong()) }
        .forEach { range ->
            range.forEach {
                if (it.toString().hasPattern()) {
                    println("count of $count incremented by $it")
                    count += it
                } else {
                    println("$it does not match pattern")
                }
            }
        }
    println("count of $count")
}

private fun String.hasPattern() =
    if (length % 2 != 0) false else {
        val (first, second) = take(length / 2) to substring(length / 2)
        first == second
    }

