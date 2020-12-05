package days

class Day5 : Day(5) {

    private val allSeats = inputList.map {
        val num = it.replace("F", "0")
                .replace("B", "1")
                .replace("L", "0")
                .replace("R", "1")
        Integer.parseInt(num, 2)
    }

    override fun partOne(): Int? {
        return allSeats.maxOrNull()
    }

    override fun partTwo(): Int {
        val min = allSeats.minOrNull() ?: 0
        val max = allSeats.maxOrNull() ?: 0
        val totalSum = (min..max).sum()
        val actualSum = allSeats.sum()
        return totalSum-actualSum
    }
}
