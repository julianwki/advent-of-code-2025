package day6

fun main() {
    val lines = input.lines().map { line -> line.split(" ").filter { it.isNotBlank() } }
    val (operands, operators) = lines.take(lines.size - 1) to lines.last()
    val result = operators.indices.map { i ->
        operands.map { it[i].toLong() }.reduce { a, b ->
            (a to b).calculate(operators[i])
        }
    }.reduce(Long::plus)
    println("Total: $result")
}

private fun Pair<Long, Long>.calculate(operand: String) =
    when (operand) {
        "*" -> first * second
        "+" -> first + second
        else -> error("Invalid operand $operand")
    }