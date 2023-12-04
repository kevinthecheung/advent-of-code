import kotlin.math.absoluteValue

class Day03 : AdventSolution() {
    data class Point(val x: Int, val y: Int)
    data class SchematicSymbol(val value: String, val location: Point)
    data class SchematicNumber(val value: Int, val location: List<Point>)

    fun isAdjacent(number: SchematicNumber, point: Point): Boolean =
        number.location.any { (it.x - point.x).absoluteValue <= 1 && (it.y - point.y).absoluteValue <= 1 }

    fun parseSchematic(input: List<String>): Pair<List<SchematicNumber>, List<SchematicSymbol>> {
        val numbers = mutableListOf<SchematicNumber>()
        val symbols = mutableListOf<SchematicSymbol>()
        for (y in input.indices) {
            symbols.addAll(symbolRegex.findAll(input[y]).map { result ->
                SchematicSymbol(result.value, Point(result.range.first, y))
            })
            numbers.addAll(numberRegex.findAll(input[y]).map { result ->
                SchematicNumber(
                    result.value.toInt(),
                    result.range.map { x -> Point(x, y) }
                )
            })
        }
        return Pair(numbers, symbols)
    }

    override fun solvePart1(input: List<String>): String {
        val (numbers, symbols) = parseSchematic(input)
        val partNumbers = numbers.filter { num -> symbols.any { sym -> isAdjacent(num, sym.location) } }
        return partNumbers.sumOf { it.value }.toString()
    }

    override fun solvePart2(input: List<String>): String {
        val (numbers, symbols) = parseSchematic(input)
        val partNumbers = numbers.filter { num -> symbols.any { sym -> isAdjacent(num, sym.location) } }
        val gearRstios = symbols.map { sym ->
            if (sym.value != "*") 0 else {
                val adjNums = partNumbers.filter { n -> isAdjacent(n, sym.location) }
                if (adjNums.size != 2) 0 else adjNums[0].value * adjNums[1].value
            }
        }
        return gearRstios.sum().toString()
    }

    companion object {
        val symbolRegex = Regex("[^\\d.]")
        val numberRegex = Regex("\\d+")
    }
}

fun main() = Day03().run()