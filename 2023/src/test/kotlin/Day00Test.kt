import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day00Test {
    @Test
    fun solve() {
        val solver = Day00()
        assertEquals("6", solver.solve(listOf("1", "2", "3")))
        assertEquals("6", solver.solve(listOf("1", "2", "3", "")))
        assertEquals(
            "6", solver.solve(
                """
                1
                2
                3
                """.trimIndent().lines()
            )
        )
    }
}