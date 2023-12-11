import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day11Test {
    val solver = Day11()

    @Test
    fun solvePart1() {
        val input = """
            ...#......
            .......#..
            #.........
            ..........
            ......#...
            .#........
            .........#
            ..........
            .......#..
            #...#.....
        """.trimIndent().lines()
        assertEquals("374", solver.solvePart1(input))
    }
}