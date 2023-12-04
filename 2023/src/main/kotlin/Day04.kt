import kotlin.math.pow

class Day04 : AdventSolution() {
    override fun solvePart1(input: List<String>): String {
        val cardPoints = input.map { card ->
            val parsedCard = cardRegex.matchEntire(card) ?: throw Error("Bad card.")
            val winners = parsedCard.groupValues[2].trim().split(Regex("\\s+")).map { it.toInt() }.toSet()
            val picks = parsedCard.groupValues[3].trim().split(Regex("\\s+")).map { it.toInt() }.toSet()
            val matches = winners intersect picks
            val points = if (matches.isEmpty()) 0.0 else (2.0).pow(matches.size - 1)
            points
        }
        return cardPoints.sum().toString()
    }

    override fun solvePart2(input: List<String>): String {
        TODO("Not yet implemented")
    }

    companion object {
        val cardRegex = Regex("^Card\\s+(\\d+):([\\d\\s]*)\\|([\\d\\s]*)$")
    }
}

fun main() = Day04().run()