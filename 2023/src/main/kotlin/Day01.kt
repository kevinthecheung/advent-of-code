class Day01 : AdventSolution() {
    override fun solvePart1(input: List<String>): String {
        val solution = input
            .map { it.filter { c -> c.isDigit() } }
            .map { "${it.first()}${it.last()}".toInt() }
            .sum()
        return solution.toString()
    }

    override fun solvePart2(input: List<String>): String {
        val solution = input
            .map {
                val digits = mutableListOf<Int>()
                var str = it
                while (str.isNotEmpty()) {
                    if (str[0].isDigit()) {
                        digits.add(str.substring(0, 1).toInt())
                    } else {
                        for (word in digitWords) {
                            if (str.startsWith(word)) {
                                digits.add(digitWords.indexOf(word))
                                break
                            }
                        }
                    }
                    str = str.substring(1)
                }
                digits.toList()
            }
            .map { 10 * it.first() + it.last() }
            .sum()
        return solution.toString()
    }

    companion object {
        val digitWords = listOf(
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
        )
    }
}

fun main() = Day01().run()