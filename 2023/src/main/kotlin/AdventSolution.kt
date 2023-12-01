abstract class AdventSolution {
    abstract fun solvePart1(input: List<String>): String
    abstract fun solvePart2(input: List<String>): String

    fun run(inputFileName: String? = null) {
        val input = readInputFromResource(inputFileName ?: "${this.javaClass.name}.txt")
        println(this.javaClass.name)
        println(this.solvePart1(input))
        println(this.solvePart2(input))
    }

    companion object {
        fun readInputFromResource(inputFileName: String): List<String> =
            this::class.java.getResourceAsStream(inputFileName)!!.bufferedReader().readLines()
    }
}