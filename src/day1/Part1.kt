package day1

fun main() {
    var position = 50
    var zeros = 0
    println("The dial starts by pointing at $position")
    input.lines().forEach { line ->
        run {
            val direction = line.take(1)
            when (direction) {
                "L" -> position -= line.substring(1).toInt() % 100
                "R" -> position += line.substring(1).toInt() % 100
            }
            if (position < 0) position += 100
            if (position > 99) position -= 100
            println("The dial is rotated $line to point at $position.")
            if (position == 0) zeros++
        }
    }
    println("Zeros: $zeros")
}