import kotlin.math.absoluteValue

class Day11 : AdventSolution() {
    data class Coord(val x: Int, val y: Int)

    override fun solvePart1(input: List<String>): String {
        var galaxies = input.flatMapIndexed { y, r -> r.mapIndexed { x, c -> if (c == '#') Coord(x, y) else null} }.filterNotNull()
        var emptyRows = input.mapIndexed { i, r -> if (r.all { it == '.' }) i else null }.filterNotNull()
        var emptyCols = input[0].indices.filter { i -> input.map { r -> r[i] }.all { it == '.' } }

        while (emptyRows.isNotEmpty()) {
            galaxies = galaxies.map { if (it.y > emptyRows[0]) Coord(it.x, it.y + 1) else it }
            emptyRows = emptyRows.slice(1..<emptyRows.size).map { it + 1 }
        }
        while (emptyCols.isNotEmpty()) {
            galaxies = galaxies.map { if (it.x > emptyCols[0]) Coord(it.x + 1, it.y) else it }
            emptyCols = emptyCols.slice(1..<emptyCols.size).map { it + 1 }
        }

        val distances = galaxies.flatMap { g1 -> galaxies.map { g2 -> setOf(g1, g2) } }.filter { it.size == 2 }.toSet()
            .map {
                val (g1, g2) = it.toList()
                (g1.x - g2.x).absoluteValue + (g1.y - g2.y).absoluteValue
            }
        return distances.sum().toString()
    }

    override fun solvePart2(input: List<String>): String {
        TODO("Not yet implemented")
    }
}

fun main() = Day11().run()