package days



class Day14 : Day(14) {

    private val memory: MutableMap<Long, Long> = mutableMapOf()
    private val regex = """mem\[(\d+)] = (\d+)""".toRegex()

    override fun partOne(): Long {
        val regex = """mem\[(\d+)] = (\d+)""".toRegex()

        var andMask: Long = 0
        var orMask: Long = 1

        inputList.forEach {
            if (it.startsWith("mask =")) {
                andMask = it.drop(7)
                    .replace('X', '1')
                    .toLong(2)
                orMask = it.drop(7)
                    .replace('X', '0')
                    .toLong(2)
            } else {
                val matchResult = regex.find(it)
                val (adr, value) = matchResult!!.destructured
                val maskedVal = value.toLong() and andMask or orMask
                memory[adr.toLong()] = maskedVal
            }
        }
        return memory.values.sum()
    }

    override fun partTwo(): Int {
        return 0
    }
}
