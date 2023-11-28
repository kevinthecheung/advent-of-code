class Day00 : AdventSolution() {
    override fun solve(input: List<String>): String {
        val solution = input.map { it.toIntOrNull() ?: 0 }.reduce { i, j -> i + j }
        return solution.toString()
    }
}

fun main() = Day00().run()