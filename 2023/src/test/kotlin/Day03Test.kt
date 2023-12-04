import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day03Test {
    private val solver = Day03()

    @Test
    fun solvePart1() {
        val input = """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...$.*....
            .664.598..
        """.trimIndent().lines()
        assertEquals("4361", solver.solvePart1(input))
    }

    @Test
    fun solvePart2() {
        val input = """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...$.*....
            .664.598..
        """.trimIndent().lines()
        assertEquals("467835", solver.solvePart2(input))
    }
}