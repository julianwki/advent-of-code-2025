package day6

fun main() {
    with(input) {
        val lines = (listOf(lines().last()) + lines().take(lines().size - 1)).map { it.asSequence().toList() }
        var result = 0L
        val operations = mutableListOf<String>()
        for (i in lines[0].indices) {
            var operator = ""
            var operand = ""
            for (j in lines.indices) {
                val c = lines[j][i]
                if (j == lines.indices.first && c != ' ') {
                    operator = c.toString()
                } else {
                    operand += c.toString().trim()
                }
            }
            if (operator.isNotBlank()) {
                operations.add(operator)
            }
            if (operand.isNotBlank()) {
                operations.add(operand)
            }
        }
        var operator = ""
        val operands = mutableListOf<Long>()
        for (o in operations) {
            if (operator.isNotBlank() && o.isNotLong()) {
                result += operands.calculate(operator)
                operands.clear()
                operator = ""
            }
            if (o.isLong()) {
                operands.add(o.toLong())
            } else {
                operator = o
            }
        }
        result += operands.calculate(operator)
        println("Total: $result")
    }
}

private fun String.isLong() = this.toLongOrNull() != null
private fun String.isNotLong() = this.toLongOrNull() == null

private fun List<Long>.calculate(operand: String) =
    if (isEmpty()) 0 else reduce { a, b -> (a to b).calculate(operand) }

private fun Pair<Long, Long>.calculate(operand: String) =
    when (operand.trim()) {
        "*" -> first * second
        "+" -> first + second
        else -> error("Invalid operand $operand")
    }