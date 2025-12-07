package day4

fun main() {
    var paperRolls = 0
    val grid = input.lines().map { it.asSequence().toMutableList() }
    val xMax = grid.size - 1
    do {
        val paperRollCells = mutableListOf<Pair<Int, Int>>()
        IntRange(0, xMax).forEach { x ->
            val yMax = grid[x].size - 1
            IntRange(0, yMax).forEach { y ->
                var adjacentPaperRolls = 0
                if (x - 1 >= 0 && y - 1 >= 0 && grid[x - 1][y - 1] == '@') adjacentPaperRolls++
                if (x - 1 >= 0 && grid[x - 1][y] == '@') adjacentPaperRolls++
                if (x - 1 >= 0 && y + 1 <= yMax && grid[x - 1][y + 1] == '@') adjacentPaperRolls++
                if (y - 1 >= 0 && grid[x][y - 1] == '@') adjacentPaperRolls++
                if (y + 1 <= yMax && grid[x][y + 1] == '@') adjacentPaperRolls++
                if (x + 1 <= xMax && y - 1 >= 0 && grid[x + 1][y - 1] == '@') adjacentPaperRolls++
                if (x + 1 <= xMax && grid[x + 1][y] == '@') adjacentPaperRolls++
                if (x + 1 <= xMax && y + 1 <= yMax && grid[x + 1][y + 1] == '@') adjacentPaperRolls++
                if (adjacentPaperRolls < 4 && grid[x][y] == '@') {
                    print('X')
                    paperRollCells.add(x to y)
                } else {
                    print(grid[x][y])
                }
            }
            println()
        }
        paperRollCells.forEach { grid[it.first][it.second] = '.' }
        println("Subtotal: ${paperRollCells.size}")
        paperRolls += paperRollCells.size
        println()
    } while (paperRollCells.isNotEmpty())
    println("Total: $paperRolls")
}