class Day08 : AdventSolution() {
    override fun solvePart1(input: List<String>): String {
        val directions = input[0]
        val map = mutableMapOf<String, Map<Char, String>>().apply {
            for (line in input.slice(2..<input.size)) {
                val (_, loc, left, right) = mapRegex.matchEntire(line)!!.groupValues
                this[loc] = mapOf(Pair('L', left), Pair('R', right))
            }
        }.toMap()

        var step = 0
        var loc = "AAA"
        while (loc != "ZZZ") {
            val d = directions[step % directions.length]
            loc = map[loc]!![d]!!
            step += 1
        }
        return step.toString()
    }

    override fun solvePart2(input: List<String>): String {
        val directions = input[0]
        val map = mutableMapOf<String, Map<Char, String>>().apply {
            for (line in input.slice(2..<input.size)) {
                val (_, loc, left, right) = mapRegex.matchEntire(line)!!.groupValues
                this[loc] = mapOf(Pair('L', left), Pair('R', right))
            }
        }.toMap()

        val locs = map.keys.filter { k -> k.last() == 'A' }
        val steps = locs.map {
            var loc = it
            var step = 0L
            while (loc.last() != 'Z') {
                val d = directions[(step % directions.length).toInt()]
                loc = map[loc]!![d]!!
                step += 1
            }
            step
        }
        val s = steps.max()
        var n = s
        while (steps.any { n % it != 0L }) n += s
        return n.toString()
    }

    companion object {
        val mapRegex = Regex("(\\w+) = \\((\\w+), (\\w+)\\)")
    }
}

fun main() = Day08().run()