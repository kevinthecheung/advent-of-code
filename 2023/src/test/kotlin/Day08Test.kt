import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day08Test {
    val solver = Day08()

    @Test
    fun solvePart1_1() {
        val input = """
            RL

            AAA = (BBB, CCC)
            BBB = (DDD, EEE)
            CCC = (ZZZ, GGG)
            DDD = (DDD, DDD)
            EEE = (EEE, EEE)
            GGG = (GGG, GGG)
            ZZZ = (ZZZ, ZZZ)
        """.trimIndent().lines()
        assertEquals("2", solver.solvePart1(input))
    }

    @Test
    fun solvePart1_2() {
        val input = """
            LLR

            AAA = (BBB, BBB)
            BBB = (AAA, ZZZ)
            ZZZ = (ZZZ, ZZZ)
        """.trimIndent().lines()
        assertEquals("6", solver.solvePart1(input))
    }

    @Test
    fun solvePart2() {
        val input = """
            LR
            
            11A = (11B, XXX)
            11B = (XXX, 11Z)
            11Z = (11B, XXX)
            22A = (22B, XXX)
            22B = (22C, 22C)
            22C = (22Z, 22Z)
            22Z = (22B, 22B)
            XXX = (XXX, XXX)
        """.trimIndent().lines()
        assertEquals("6", solver.solvePart2(input))
    }
}