package day5

fun main() {
    val freshIngredientRanges = input.lines()
        .filter { it != "" && it.contains("-") }
        .map { it.split("-") }
        .map { it[0].toLong().rangeTo(it[1].toLong()) }
    var amountFreshIngredientIds = 0L
    var consolidated = LongRange.EMPTY
    for (current in freshIngredientRanges.sortedWith(compareBy({ it.first }, { it.last }))) {
        if (consolidated.containsEndOf(current)) {
            continue
        } else if (consolidated.containsStartOf(current) || consolidated.touchesStartOf(current)) {
            consolidated = consolidated.first.rangeTo(current.last)
        } else {
            amountFreshIngredientIds += consolidated.count()
            consolidated = current
        }
    }
    amountFreshIngredientIds += consolidated.count()
    println("Total: $amountFreshIngredientIds")
}

private fun LongRange.containsEndOf(range: LongRange) =
    this.contains(range.last)
private fun LongRange.containsStartOf(range: LongRange) =
    this.contains(range.first)
private fun LongRange.touchesStartOf(range: LongRange) =
    this.last + 1 == range.first

private fun LongRange.count() = (last - first + 1)
    .also { if (it > 0) println("range[$this]: $it") }