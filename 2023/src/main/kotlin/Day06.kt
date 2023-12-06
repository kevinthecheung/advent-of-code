class Day06 : AdventSolution() {
  override fun solvePart1(input: List<String>): String {
    val times = input[0].filter { c -> c.isDigit() || c.isWhitespace() }
      .trim()
      .split(Regex("\\s+"))
      .map { it.toInt() }
    val recordDistances = input[1].filter { c -> c.isDigit() || c.isWhitespace() }
      .trim()
      .split(Regex("\\s+"))
      .map { it.toInt() }
    val distances = times.map { t -> (1..<t).toList().map { (t - it) * it } }
    val winningRuns = distances.mapIndexed { i, outcomes -> outcomes.filter { it > recordDistances[i] } }
    val margin = winningRuns.map { it.size }.reduce { acc, i -> acc * i }
    return margin.toString()
  }

  override fun solvePart2(input: List<String>): String {
    val time = input[0].filter { c -> c.isDigit() }.toLong()
    val recordDistance = input[1].filter { c -> c.isDigit() }.toLong()
    val distances = (1..<time).toList().map { (time - it) * it }
    val winningRuns = distances.filter { it > recordDistance }
    val margin = winningRuns.size
    return margin.toString()
  }
}

fun main() = Day06().run()