package day5

fun main() {
    with(input) {
        val freshIngredientRanges = this.lines()
            .filter { it != "" && it.contains("-") }
            .map { it.split("-") }
            .map { LongRange(it[0].toLong(), it[1].toLong()) }
        val availableIngredients = this.lines()
            .filter { it != "" && it.contains("-").not() }
            .map { it.toLong() }
        val freshIngredients = availableIngredients
            .map { ingredient -> if (freshIngredientRanges.any {it.contains(ingredient)}) 1 else 0 }
            .reduce(Int::plus)
        println("Total: $freshIngredients")
    }
}