package days

class Day6 : Day(6) {

    override fun partOne(): Int {
        return inputString
                .split("\n\n")
                .map {
                    it.replace(Regex("\\s"), "")
                        .toSet()
                        .count()
                }.sum()
    }

    override fun partTwo(): Int {
        return inputString
                .split("\n\n")
                .map {
                    it.split("\n")
                        .map(String::toSet)
                        .reduce(Set<Char>::intersect)
                        .count()
                }.sum()
    }
}
