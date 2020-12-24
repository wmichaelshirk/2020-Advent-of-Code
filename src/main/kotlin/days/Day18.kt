package days



class Day18 : Day(18) {

    private fun evaluate(input: String): Long {
        var stack = mutableListOf<String>()
        input.filter { it != ' ' }
            .split("")
            .forEach { el ->
                when(el) {
                    ")" -> {
                        val exp = stack.takeLastWhile { it != "(" }
                        val expVal = lToR(exp)
                        val ind = stack.indexOfLast { it == "(" }
                        stack = stack.subList(0, ind)
                        stack.add(expVal.toString())
                    }
                    else -> stack.add(el)
                }
            }

        return lToR(stack)
    }

    private fun lToR(list: List<String>): Long {
        var curVal = 0L
        var curOp: String? = null
        list.filter{ it.isNotBlank() }
            .forEach {
                when (it) {
                    "+" -> curOp = it
                    "*" -> curOp = it
                    else -> {
                        if (curOp != null) {
                            if (curOp == "+") {
                                curVal += it.toLong()
                                curOp = null
                            } else {
                                curVal *= it.toLong()
                                curOp = null
                            }
                        } else {
                            curVal = it.toLong()
                        }
                    }
                }
        }
        return curVal
    }


    override fun partOne(): Long {
        return inputList
            .map(::evaluate)
            .sum()
    }

    override fun partTwo(): Int {
        return 0
    }
}
