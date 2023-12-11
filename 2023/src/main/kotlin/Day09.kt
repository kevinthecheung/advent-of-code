class Day09 : AdventSolution() {
    override fun solvePart1(input: List<String>): String {
        val extrapolated = input.map { str ->
            val diffses = mutableListOf(str.split(Regex("\\s+")).map { it.toInt() })
            while (diffses.last().any { it != 0 }) {
                val seq = diffses.last()
                diffses.addLast((1..<seq.size).map { i -> seq[i] - seq[i - 1] })
            }
            while (diffses.size > 1) {
                val diff = diffses.last().last()
                diffses.removeLast()
                diffses.last().addLast(diffses.last().last() + diff)
            }
            diffses[0]
        }
        val sol = extrapolated.sumOf { it.last() }
        return sol.toString()
    }

    override fun solvePart2(input: List<String>): String {
        val extrapolated = input.map { str ->
            val diffses = mutableListOf(str.split(Regex("\\s+")).map { it.toInt() })
            while (diffses.last().any { it != 0 }) {
                val seq = diffses.last()
                diffses.addLast((1..<seq.size).map { i -> seq[i] - seq[i - 1] })
            }
            while (diffses.size > 1) {
                val diff = diffses.last().first()
                diffses.removeLast()
                diffses.last().addFirst(diffses.last().first() - diff)
            }
            diffses[0]
        }
        val sol = extrapolated.sumOf { it.first() }
        return sol.toString()
    }
}

fun main() = Day09().run()