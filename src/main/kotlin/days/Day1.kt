package days

class Day1 : Day(1) {

    //    Before you leave, the Elves in accounting just need you to fix your expense report
    //    (your puzzle input);  apparently, something isn't quite adding up.
    //
    //    Specifically, they need you to find the two entries that sum to 2020 and then multiply
    //    those two numbers together.
    override fun partOne(): Int? {
        val entries = inputList.map { it.toInt() }

        for (v1 in entries) {
            for (v2 in entries) {
                if (v1 + v2 == 2020) {
                    return v1 * v2
                }
            }
        }
        return null
    }

    //    The Elves in accounting are thankful for your help; one of them even offers you a
    //    starfish coin they had left over from a past vacation. They offer you a second one
    //    if you can find three numbers in your expense report that meet the same criteria.
    //
    //    Using the above example again, the three entries that sum to 2020 are 979, 366, and
    //    675. Multiplying them together produces the answer, 241861950.
    //
    //    In your expense report, what is the product of the three entries that sum to 2020?
    override fun partTwo(): Int? {
        val entries = inputList.map { it.toInt() }

        for (v1 in entries) {
            for (v2 in entries) {
                for (v3 in entries) {
                    if (v1 + v2 + v3 == 2020) {
                        return v1 * v2 * v3
                    }
                }
            }
        }
        return null
    }
}
