package days

import java.math.BigInteger

class Day3 : Day(3) {

    // Starting at the top-left corner of your map and following a slope of right 3 and down 1,
    // how many trees would you encounter?

    override fun partOne(): Int {
        val slope = 3
        var x = 0
        return inputList.filter {
            val oldX = x
            x = (x + slope) % it.length
            it[oldX] == '#'
        }.count()
    }

    override fun partTwo(): Long {
        val slopes = listOf(
            Pair(1, 1),
            Pair(3, 1),
            Pair(5, 1),
            Pair(7, 1),
            Pair(1, 2)
        )
        return slopes.map {
            var x = 0
            inputList.filterIndexed { i, row ->
                if (i % it.second == 0) {
                    val oldX = x
                    x = (x + it.first) % row.length
                    row[oldX] == '#'
                } else {
                    false
                }
            }.count().toLong()
        }.reduce(Long::times)
    }
}
