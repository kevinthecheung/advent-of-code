import kotlin.math.pow

class Day04 : AdventSolution() {
    data class ScratchCard(val id: Int, val winners: Set<Int>, val picks: Set<Int>)

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
        val scratcherdex = mutableMapOf<Int, ScratchCard>()
        for (card in input) {
            val parsedCard = cardRegex.matchEntire(card) ?: throw Error("Bad card.")
            val id = parsedCard.groupValues[1].toInt()
            val winners = parsedCard.groupValues[2].trim().split(Regex("\\s+")).map { it.toInt() }.toSet()
            val picks = parsedCard.groupValues[3].trim().split(Regex("\\s+")).map { it.toInt() }.toSet()
            scratcherdex[id] = ScratchCard(id, winners, picks)
        }
        val myCards = scratcherdex.values.toMutableList()
        var i = 0
        while (i < myCards.size) {
            val card = myCards[i]
            val numMatches = (card.winners intersect card.picks).size
            for (n in 1..numMatches) {
                myCards.addLast(scratcherdex[card.id + n])
            }
            i += 1
        }
        return myCards.size.toString()
    }

    companion object {
        val cardRegex = Regex("^Card\\s+(\\d+):([\\d\\s]*)\\|([\\d\\s]*)$")
    }
}

fun main() = Day04().run()