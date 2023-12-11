import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day09Test {
    val solver = Day09()

    @Test
    fun solvePart1() {
        val input = """
            0 3 6 9 12 15
            1 3 6 10 15 21
            10 13 16 21 30 45
        """.trimIndent().lines()
        assertEquals("114", solver.solvePart1(input))
    }

    @Test
    fun solvePart2() {
        val input = """
            0 3 6 9 12 15
            1 3 6 10 15 21
            10 13 16 21 30 45
        """.trimIndent().lines()
        assertEquals("2", solver.solvePart2(input))
    }
}