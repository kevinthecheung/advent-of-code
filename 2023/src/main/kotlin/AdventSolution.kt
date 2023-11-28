abstract class AdventSolution {
    abstract fun solve(input: List<String>): String

    fun run(inputFileName: String? = null) {
        val input = readInputFromResource(inputFileName ?: "${this.javaClass.name}.txt")
        println(this.javaClass.name)
        println(this.solve(input))
    }

    companion object {
        fun readInputFromResource(inputFileName: String): List<String> =
            this::class.java.getResourceAsStream(inputFileName)!!.bufferedReader().readLines()
    }
}