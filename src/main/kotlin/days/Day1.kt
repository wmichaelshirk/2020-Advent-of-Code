package days

class Day1 : Day(1) {

    //    Before you leave, the Elves in accounting just need you to fix your expense report (your puzzle input);
    //    apparently, something isn't quite adding up.
    //
    //    Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers
    //    together.
    override fun partOne(): Any {
        val entries = inputList.map { it.toInt() }

        for ((index, v1) in entries.withIndex()) {
            val target = 2020 - v1
            val innerEntries = entries.drop(index)
            if (innerEntries.contains(target)) {
                return target * v1
            }
        }
        return 0
    }

    //    The Elves in accounting are thankful for your help; one of them even offers you a starfish coin they had left
    //    over from a past vacation. They offer you a second one if you can find three numbers in your expense report
    //    that meet the same criteria.
    //
    //    Using the above example again, the three entries that sum to 2020 are 979, 366, and 675. Multiplying them
    //    together produces the answer, 241861950.
    //
    //    In your expense report, what is the product of the three entries that sum to 2020?
    override fun partTwo(): Any {
        val entries = inputList.map { it.toInt() }

        for ((index, v1) in entries.withIndex()) {
            val target = 2020 - v1
            val innerEntries = entries.drop(index)
            for ((i2, v2) in innerEntries.withIndex()) {
                val finalTarget = target - v2
                if (innerEntries.drop(i2).contains(finalTarget)) {
                    return v2 * finalTarget * v1
                }
            }
        }
        return 0
    }
}
