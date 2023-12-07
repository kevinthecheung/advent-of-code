class Day07 : AdventSolution() {
    override fun solvePart1(input: List<String>): String {
        val handsAndBids = input.map {
            val (h, b) = it.split(Regex("\\s+"))
            Pair(h, b.toInt())
        }.sortedWith { a, b -> handComparator.compare(a.first, b.first) }
        val winnings = handsAndBids.mapIndexed { i, hb -> hb.second * (i + 1) }
        val total = winnings.sum()
        return total.toString()
    }

    override fun solvePart2(input: List<String>): String {
        TODO("Not yet implemented")
    }

    companion object {
        val cardLabels = listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A')

        fun handValue(hand: String): Int {
            val labelCounts = cardLabels.map { c -> hand.filter { it == c }.length }
            return when {
                labelCounts.max() == 5 -> 6
                labelCounts.max() == 4 -> 5
                labelCounts.contains(3) && labelCounts.contains(2) -> 4
                labelCounts.contains(3) -> 3
                labelCounts.filter { it == 2 }.size == 2 -> 2
                labelCounts.contains(2) -> 1
                else -> 0
            }
        }

        val handComparator = Comparator<String> { a, b ->
            val aVal = handValue(a)
            val bVal = handValue(b)
            if (aVal != bVal) {
                return@Comparator aVal - bVal
            }
            for (i in a.indices) {
                if (a[i] != b[i]) {
                    return@Comparator cardLabels.indexOf(a[i]) - cardLabels.indexOf(b[i])
                }
            }
            0
        }
    }
}

fun main() = Day07().run()