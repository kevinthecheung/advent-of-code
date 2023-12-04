class Day02 : AdventSolution() {
    data class DrawResult(val reds: Int, val greens: Int, val blues: Int)
    data class GameResult(val id: Int, val draws: List<DrawResult>)

    fun isValidGame(result: GameResult, totalReds: Int, totalGreens: Int, totalBlues: Int): Boolean =
        result.draws.none { drawResult ->
            drawResult.reds > totalReds
                    || drawResult.greens > totalGreens
                    || drawResult.blues > totalBlues
        }

    fun parseGameResult(str: String): GameResult {
        val (idStr, drawsStr) = str.split(":")
        val id = idStr.filter { it.isDigit() }.toInt()
        val draws = drawsStr.split(";").map { draw ->
            val reds = redCountRegex.find(draw)?.groupValues?.get(1)?.toInt() ?: 0
            val greens = greenCountRegex.find(draw)?.groupValues?.get(1)?.toInt() ?: 0
            val blues = blueCountRegex.find(draw)?.groupValues?.get(1)?.toInt() ?: 0
            DrawResult(reds, greens, blues)
        }
        return GameResult(id, draws)
    }

    override fun solvePart1(input: List<String>): String {
        val results = input.map { parseGameResult(it) }
        val validGames = results.filter { isValidGame(it, 12, 13, 14) }
        return validGames.sumOf { it.id }.toString()
    }

    override fun solvePart2(input: List<String>): String {
        TODO("Not yet implemented")
    }

    companion object {
        val redCountRegex = Regex("(\\d+) red")
        val greenCountRegex = Regex("(\\d+) green")
        val blueCountRegex = Regex("(\\d+) blue")
    }
}

fun main() = Day02().run()