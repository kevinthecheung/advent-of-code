import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day01Test {
    val solver = Day01()

    @Test
    fun solvePart1() {
        val input = """
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
        """.trimIndent().lines()
        assertEquals("142", solver.solvePart1((input)))
    }

    @Test
    fun solvePart2() {
        val input = """
            two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen
        """.trimIndent().lines()
        assertEquals("281", solver.solvePart2((input)))

        val input2 = """
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
        """.trimIndent().lines()
        assertEquals("142", solver.solvePart2((input2)))
    }
}