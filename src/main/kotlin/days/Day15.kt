package days

class Day15 : Day(15) {

    private fun countUntil(target: Int): Int {
        var nextNum = 0
        var count = 0
        val lastNumbers = mutableMapOf<Int, Int>()

        inputString.split(',')
            .map(String::toInt)
            .forEach {
                count += 1
                nextNum = lastNumbers.getOrDefault(it, 0)
                lastNumbers[it] = count
            }

        while (count < target-1) {
            val oldNext = nextNum
            val diff = lastNumbers.getOrDefault(nextNum, 0)
            count += 1
            nextNum =
                if (diff == 0) 0
                else count - diff
            lastNumbers[oldNext] = count
        }
        return nextNum
    }

    override fun partOne(): Int {
        return countUntil(2020)
    }

    override fun partTwo(): Int {
        return countUntil(30000000)
    }
}
