class Day07 {}

data class Bag(val description: String)
data class AllowedContent(val count: Int, val description: String)
typealias BagRules = Map<String, List<AllowedContent>>

fun Bag.canContain(bag: String, rules: BagRules): Boolean {
    val allowedContents = rules[this.description] ?: throw Exception()
    return when {
        allowedContents.isEmpty() -> false
        bag in allowedContents.map { it.description } -> true
        else -> allowedContents.fold(false) { canContain, allowedContent ->
            canContain || Bag(allowedContent.description).canContain(bag, rules)
        }
    }
}

fun Bag.bagsWithin(rules: BagRules): Int {
    val allowedContents = rules[this.description] ?: throw Exception()
    return when {
        allowedContents.isEmpty() -> 0
        else -> allowedContents.map { it.count * (1 + Bag(it.description).bagsWithin(rules)) }.sum()
    }
}

fun getRules(input: String): BagRules = input.split("\n").map { parseRule(it) }.toMap()

val ruleRegex = Regex("""(.+ bag)s contain (.*)\.""")
val allowedRegex = Regex("""(\d+) (.+?)s?""")
fun parseRule(input: String): Pair<String, List<AllowedContent>> {
    val (container, allowedStr) = ruleRegex.matchEntire(input)?.destructured ?: throw Exception()
    val allowed = if (allowedStr.strip() == "no other bags") {
        emptyList()
    } else {
        allowedStr.split(",").map {
            val (count, description) = allowedRegex.matchEntire(it.strip())?.destructured ?: throw Exception()
            return@map AllowedContent(count.toInt(), description.strip())
        }
    }
    return Pair(container, allowed)
}

fun main() {
    val input = Day07::javaClass.javaClass.classLoader.getResource("day07.txt")?.readText() ?: ""

    val rules = getRules(input)
    val canContainGold = rules.map { it.key }
        .filter { bag -> Bag(bag).canContain("shiny gold bag", rules) }
        .size
    println(canContainGold)

    val goldBagContents = Bag("shiny gold bag").bagsWithin(rules)
    println(goldBagContents)
}