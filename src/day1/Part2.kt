package day1

fun main() {
    var position = 50
    var zeros = 0
    println("The dial starts by pointing at $position")
    input.lines().forEach { line ->
        run {
            val direction = Direction.valueOf(line.take(1))
            val clicks = line.substring(1).toInt()
            repeat(clicks) {
                position = position.click(direction)
                if (position.zero) zeros++
            }
            println("The dial is rotated $line to point at $position.")
        }
    }
    println("Zeros: $zeros")
}

private fun Int.click(direction: Direction) = direction.click(this)

private val Int.zero
    get() = this % 100 == 0

enum class Direction {
    L {
        override fun click(position: Int) = if (position != 0) position.dec() else 99
    },
    R {
        override fun click(position: Int) = if (position != 99) position.inc() else 0
    };

    abstract fun click(position: Int): Int
}
