package days

class Day8 : Day(8) {

    private var pointer: Int = 0
    private var acc: Int = 0

    private val ops = mapOf<String, (Int) -> Unit>(
        "nop" to { _ -> pointer += 1 },
        "acc" to { arg -> acc += arg; pointer += 1 },
        "jmp" to { arg -> pointer += arg }
    )

    private fun runProgram(input: List<String>): Int? {
        pointer = 0
        acc = 0
        val visited = mutableSetOf<Int>()
        val limit = input.size
        while (!visited.contains(pointer)) {
            visited.add(pointer)
            val (opp, arg) = input[pointer].split(' ')
            ops[opp]?.invoke(arg.toInt())
            if (pointer >= limit) return acc
        }
        return null
    }

    override fun partOne(): Int {
        runProgram(inputList)
        return acc
    }

    override fun partTwo(): Int {
        return inputList
            .asSequence()
            .mapIndexed { index, s -> index to s }
            .filter {
                it.second.startsWith("jmp") or
                        it.second.startsWith("nop")
            }.map {
                val newList = inputList.toMutableList()
                newList[it.first] = if (it.second.contains("jmp")) {
                    it.second.replace("jmp", "nop")
                } else {
                    it.second.replace("nop", "jmp")
                }
                newList
            }.map { runProgram(it) }
            .first { it != null } ?: 0
    }
}
