import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class Day06Test {
  private val solver = Day06()

  @Test
  fun solvePart1() {
    val input = """
      Time:      7  15   30
      Distance:  9  40  200
    """.trimIndent().lines()
    assertEquals("288", solver.solvePart1(input))
  }

  @Test
  fun solvePart2() {
    val input = """
      Time:      7  15   30
      Distance:  9  40  200
    """.trimIndent().lines()
    assertEquals("71503", solver.solvePart2(input))
  }
}