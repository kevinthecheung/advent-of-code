import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day07Test {
    private val solver = Day07()

    @Test
    fun solvePart1() {
        val input = """
            32T3K 765
            T55J5 684
            KK677 28
            KTJJT 220
            QQQJA 483
        """.trimIndent().lines()
        assertEquals("6440", solver.solvePart1(input))
    }

    @Test
    fun solvePart2() {
        val input = """
            32T3K 765
            T55J5 684
            KK677 28
            KTJJT 220
            QQQJA 483
        """.trimIndent().lines()
        assertEquals("5905", solver.solvePart2(input))
    }
}