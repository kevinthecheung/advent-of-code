class Day02 : AdventSolution() {
    data class CubeSet(val reds: Int, val greens: Int, val blues: Int)
    data class GameResult(val id: Int, val draws: List<CubeSet>)

    fun isValidGame(result: GameResult, totalReds: Int, totalGreens: Int, totalBlues: Int): Boolean =
        result.draws.none { drawResult ->
            drawResult.reds > totalReds
                    || drawResult.greens > totalGreens
                    || drawResult.blues > totalBlues
        }

    fun minimumCubeSet(gameResult: GameResult): CubeSet {
        val minReds = gameResult.draws.maxBy { it.reds }.reds
        val minGreens = gameResult.draws.maxBy { it.greens }.greens
        val minBlues = gameResult.draws.maxBy { it.blues }.blues
        return CubeSet(minReds, minGreens, minBlues)
    }

    fun parseGameResult(str: String): GameResult {
        val (idStr, drawsStr) = str.split(":")
        val id = idStr.filter { it.isDigit() }.toInt()
        val draws = drawsStr.split(";").map { draw ->
            val reds = redCountRegex.find(draw)?.groupValues?.get(1)?.toInt() ?: 0
            val greens = greenCountRegex.find(draw)?.groupValues?.get(1)?.toInt() ?: 0
            val blues = blueCountRegex.find(draw)?.groupValues?.get(1)?.toInt() ?: 0
            CubeSet(reds, greens, blues)
        }
        return GameResult(id, draws)
    }

    override fun solvePart1(input: List<String>): String {
        val results = input.map { parseGameResult(it) }
        val validGames = results.filter { isValidGame(it, 12, 13, 14) }
        return validGames.sumOf { it.id }.toString()
    }

    override fun solvePart2(input: List<String>): String {
        val results = input.map { parseGameResult(it) }
        val powers = results.map { result -> minimumCubeSet(result) }.map { it.reds * it.greens * it.blues }
        return powers.sum().toString()
    }

    companion object {
        val redCountRegex = Regex("(\\d+) red")
        val greenCountRegex = Regex("(\\d+) green")
        val blueCountRegex = Regex("(\\d+) blue")
    }
}

fun main() = Day02().run()