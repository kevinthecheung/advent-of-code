import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day10Test {
    val solver = Day10()

    @Test
    fun solvePart1_1() {
        val input = """
            .....
            .S-7.
            .|.|.
            .L-J.
            .....
        """.trimIndent().lines()
        assertEquals("4", solver.solvePart1(input))
    }

    @Test
    fun solvePart1_2() {
        val input = """
            ..F7.
            .FJ|.
            SJ.L7
            |F--J
            LJ...
        """.trimIndent().lines()
        assertEquals("8", solver.solvePart1(input))
    }
}