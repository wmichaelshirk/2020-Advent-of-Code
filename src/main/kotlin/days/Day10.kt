package days

class Day10 : Day(10) {

    private val inputData = inputList.map(String::toInt).sorted()
    private val fullList = listOf(0) + inputData + listOf(inputData.last() + 3)

    override fun partOne(): Int? {

        val foo = fullList
            .zipWithNext()
            .map { it.second - it.first }
            .groupingBy { it }
            .eachCount()

        return foo[3]?.let { foo[1]?.times(it) }
    }


    private fun validList(list: List<Int>): Boolean = list
            .zipWithNext()
            .map { it.second - it.first }
            .none { it > 3 }

    private val cache = mutableMapOf<Pair<List<Int>, Int>, Int>()
    private fun countThem( list: List<Int>, startAt: Int = 0 ): Int {
        val key = list to startAt
        if (cache.containsKey(key)) {
            return cache[key] ?: 0
        }
        val value = if ((list.count() <= 3)) 0
            else {
                val reducedList = list.drop(startAt)
                val dropStart = if (startAt == 0) 1 else 0
                reducedList.drop(dropStart).dropLast(1)
                    .asSequence()
                    .map { list.minus(it) to list.indexOf(it) }
                    .filter { validList(it.first) }
                    .map {
                        countThem(it.first, it.second)
                    }
                    .sum() + 1
            }
        cache[key] = value
        return value
    }

    override fun partTwo(): Int {
        return countThem(fullList)
    }
}
