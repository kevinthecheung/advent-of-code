class Day12 : AdventSolution() {
    override fun solvePart1(input: List<String>): String {
        val completions = input.map { s ->
            val (pattern, groupsStr) = s.split(" ")
            val groups = groupsStr.split(",").map { it.toInt() }
            generateCompletions("", pattern, groups)
                .filter { it.length == pattern.length }
                .toList()
        }
        return completions.map { it.size }.sum().toString()
    }

    override fun solvePart2(input: List<String>): String {
        val completions = input.map { s ->
            var (pattern, groupsStr) = s.split(" ")
            pattern = "$pattern?$pattern?$pattern?$pattern?$pattern"
            groupsStr = "$groupsStr,$groupsStr,$groupsStr,$groupsStr,$groupsStr"
            val groups = groupsStr.split(",").map { it.toInt() }
            generateCompletions("", pattern, groups)
                .filter { it.length == pattern.length }
                .toList()
        }
        return completions.map { it.size }.sum().toString()
    }

    fun generateCompletions(prefix: String, pattern: String, groups: List<Int>): Sequence<String> = sequence {
        if (isValidPrefix(prefix, pattern, groups)) yield(prefix)
        if (prefix.length == pattern.length) return@sequence
        val i = prefix.length
        if (pattern[i] != '?') {
            yieldAll(generateCompletions(prefix + pattern[i], pattern, groups))
        } else {
            yieldAll(generateCompletions("$prefix.", pattern, groups))
            yieldAll(generateCompletions("$prefix#", pattern, groups))
        }
    }

    fun isValidPrefix(prefix: String, pattern: String, groups: List<Int>): Boolean {
        var g = 0
        for (m in Regex("#+").findAll(prefix)) {
            if (g >= groups.size) return false
            if (m.value.length != groups[g]) return false
            g += 1
        }
        if (groups.slice(g..<groups.size).sum() > pattern.length - prefix.length) return false
        return true
    }
}

fun main() = Day12().run()