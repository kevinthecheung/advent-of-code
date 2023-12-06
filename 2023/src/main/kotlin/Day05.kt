class Day05 : AdventSolution() {
    fun parseInput(input: List<String>): Pair<List<Long>, List<List<List<Long>>>> {
        val seeds = input[0]
            .filter { c -> c.isDigit() || c.isWhitespace() }
            .trim().split(Regex("\\s+"))
            .map { it.toLong() }

        val almanac = mutableListOf<List<List<Long>>>()
        var mapData = mutableListOf<List<Long>>()
        for (line in input.slice(3..<input.size)) {
            when {
                line.isBlank() -> {}
                line.contains("map:") -> {
                    almanac.addLast(mapData.toList())
                    mapData = mutableListOf()
                }

                line[0].isDigit() -> {
                    mapData.addLast(line.split(Regex("\\s+")).map { it.toLong() })
                }
            }
        }
        almanac.addLast(mapData.toList())

        return Pair(seeds, almanac.toList())
    }

    override fun solvePart1(input: List<String>): String {
        val (seeds, almanac) = parseInput(input)
        val locations = seeds.map { seedId ->
            var i = seedId
            for (layer in almanac) {
                for (entry in layer) {
                    val (toId, fromId, size) = entry
                    if (i in fromId..<(fromId + size)) {
                        i = toId + (i - fromId)
                        break
                    }
                }
            }
            i
        }
        val closest = locations.min()
        return closest.toString()
    }

    override fun solvePart2(input: List<String>): String {
        val (seedRanges, almanac) = parseInput(input)
        var closest = almanac.last()[0][0]
        for (i in seedRanges.indices step 2) {
            for (seedId in seedRanges[i]..<(seedRanges[i] + seedRanges[i + 1])) {
                var i = seedId
                for (layer in almanac) {
                    for (entry in layer) {
                        val (toId, fromId, size) = entry
                        if (i in fromId..<(fromId + size)) {
                            i = toId + (i - fromId)
                            break
                        }
                    }
                }
                closest = minOf(closest, i)
            }
        }
        return closest.toString()
    }
}

fun main() = Day05().run()