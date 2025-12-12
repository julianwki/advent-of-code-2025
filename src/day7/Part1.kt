package day7

fun main() {
    var splits = 0
    with(input) {
        val output = mutableListOf("${lines()[0]} 0")
        for (currentLine in lines()) {
            if (currentLine == lines().first()) {
                continue
            }
            val previousOutputLine = output.last()
            var outputLine = ""
            while (outputLine.length < currentLine.length) {
                val previousChar = previousOutputLine[outputLine.length]
                val currentChar = currentLine[outputLine.length]
                when (previousChar) {
                    'S' -> outputLine += "|"
                    '.', '^' -> outputLine += currentChar
                    '|' -> outputLine = if (currentChar == '^') outputLine.dropLast(1) + "|^|" else "$outputLine|"
                    else -> error("Invalid character $previousChar")
                }
                if (previousChar == '|' && currentChar == '^') splits += 1
            }
            output.add(outputLine)
            println("$outputLine $splits")
        }
    }
    println()
    println("tachyon beam is split $splits times")
}