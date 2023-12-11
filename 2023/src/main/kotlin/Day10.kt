class Day10 : AdventSolution() {
    data class Loc(val x: Int, val y: Int)

    override fun solvePart1(input: List<String>): String {
        val pipeMap = input
        val start = let {
            var loc: Loc? = null
            search@ for (y in pipeMap.indices)
                for (x in pipeMap[y].indices)
                    if (pipeMap[y][x] == 'S') {
                        loc = Loc(x, y)
                        break@search
                    }
            loc!!
        }

        val loop = mutableListOf(start)
        var current = when {
            pipeMap.getOrNull(start.y - 1)?.getOrNull(start.x) in listOf('7', '|', 'F') -> Loc(start.x, start.y - 1)
            pipeMap.getOrNull(start.y)?.getOrNull(start.x - 1) in listOf('L', '-', 'F') -> Loc(start.x - 1, start.y)
            pipeMap.getOrNull(start.y)?.getOrNull(start.x + 1) in listOf('J', '-', '7') -> Loc(start.x + 1, start.y)
            pipeMap.getOrNull(start.y + 1)?.getOrNull(start.x) in listOf('J', '|', 'L') -> Loc(start.x, start.y + 1)
            else -> throw Exception()
        }
        loop.addLast(current)

        while (current != start) {
            current = when (pipeMap[current.y][current.x]) {
                '-' -> listOf(Loc(current.x - 1, current.y), Loc(current.x + 1, current.y)).first { it != loop[loop.size - 2] }
                '|' -> listOf(Loc(current.x, current.y - 1), Loc(current.x, current.y + 1)).first { it != loop[loop.size - 2] }
                '7' -> listOf(Loc(current.x - 1, current.y), Loc(current.x, current.y + 1)).first { it != loop[loop.size - 2] }
                'F' -> listOf(Loc(current.x + 1, current.y), Loc(current.x, current.y + 1)).first { it != loop[loop.size - 2] }
                'J' -> listOf(Loc(current.x - 1, current.y), Loc(current.x, current.y - 1)).first { it != loop[loop.size - 2] }
                'L' -> listOf(Loc(current.x + 1, current.y), Loc(current.x, current.y - 1)).first { it != loop[loop.size - 2] }
                else -> throw Exception()
            }
            loop.addLast(current)
        }

        return (loop.size / 2).toString()
    }

    override fun solvePart2(input: List<String>): String {
        TODO("Not yet implemented")
    }
}

fun main() = Day10().run()