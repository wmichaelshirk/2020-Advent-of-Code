package days

class Day9 : Day(9) {

    private fun sums(input: Iterable<Long>): Sequence<Long> =
        sequence {
            input.forEachIndexed { i, a ->
                input.forEachIndexed { j, b ->
                    if (i != j) yield(a + b)
                }
            }
        }

    private val inputData = inputList.map(String::toLong)

    override fun partOne(): Long? {

        val preambleSize = 25

        return inputData
            .windowed(preambleSize + 1)
            .find {
                val target = it.last()
                val preamble = it.dropLast(1)
                !sums(preamble).contains(target)
            }?.last()
    }

    override fun partTwo(): Long {
        val invalidNumber = partOne() ?: 0L
        println("target: $invalidNumber")
        val foo = inputData
            .asSequence()
            .withIndex()
            .drop(1)
            .mapNotNull { el ->
                var sum = 0L
                val target = inputData.drop(el.index - 1)
                    .takeWhile {
                        sum += it
                        sum <= invalidNumber
                    }
                if (target.sum() == invalidNumber) target else null
            }.find { it.count() > 1 }

        return (foo?.minOrNull() ?: 0) + (foo?.maxOrNull() ?: 0)
    }
}
