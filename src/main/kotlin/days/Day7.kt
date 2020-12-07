package days

class Day7 : Day(7) {

    override fun partOne(): Int {
        val myBag = mutableListOf("shiny gold bag")
        val outerBags = mutableSetOf<String>()


        while (myBag.isNotEmpty()) {
            val bagColor = myBag.removeLast()
            val containingBags = inputList.map { rule ->
                val (color, contents) = rule.split("s contain ")
                color to contents
            }.filter {
                it.second.contains(bagColor)
            }.map { it.first }
            outerBags.addAll(containingBags)
            myBag.addAll(containingBags)
        }
        return outerBags.size
    }

    override fun partTwo(): Int {
        val rules = inputList
            .map {
                val (color, contents) = it.split("s contain ")
                color to contents
            }.toMap()
        println(rules)


        val myBag = mutableListOf<String>()
        val innerBags = mutableListOf<String>("shiny gold bag")

        while (innerBags.isNotEmpty()) {
            val bagColor = innerBags.removeLast()
            val contentsString = rules[bagColor] ?: ""
            contentsString.split(", ")
                .forEach {
                    val match = Regex("(\\d+) (\\w+ \\w+ bag)").find(it)
                    val (number, color) = match?.destructured?.toList() ?: listOf("0", "")
                    repeat(number.toInt()) {
                        if (color.isNotEmpty()) {
                            innerBags.add(color)
                            myBag.add(color)
                        }
                    }
                }
        }
        return myBag.size
    }
}
