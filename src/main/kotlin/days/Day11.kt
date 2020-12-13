package days

class Day11 : Day(11) {

    private val width = inputString.indexOf('\n') + 1

    override fun partOne(): Int {
        val surroundingIndices = listOf(
            -width - 1, -width , -width + 1,
            -1, 1, width - 1, width , width + 1
        )
        var prev = listOf<Char>()
        var cur = inputString.toList()
        while (prev != cur) {
            prev = cur
            cur = prev.mapIndexed { index, s ->
                // 1) If a seat is empty (L) and there are no occupied seats adjacent to it,
                // the seat becomes occupied.
                // 2) If a seat is occupied (#) and four or more seats adjacent to it are also occupied, the seat becomes empty.
                // 3) Otherwise, the seat's state does not change.
                val surrounding = surroundingIndices
                    .map { prev.getOrNull(index + it) }
                    .count { it == '#' }

                if (s == 'L' && surrounding == 0) '#'
                else if (s == '#' && surrounding >= 4) 'L'
                else s
            }
        }
        return cur.count { it == '#' }
    }

    override fun partTwo(): Int {

        val surroundingIndices = listOf(
            -1 to -1,
            0 to -1,
            1 to -1,
            -1 to 0,
            1 to 0,
            -1 to 1,
            0 to 1,
            1 to 1
        )
        var prev = listOf<Char>()
        var cur = inputString.toList()
        while (prev != cur) {
            prev = cur
            cur = prev.mapIndexed { index, s ->
                // 1) If a seat is empty (L) and there are no occupied seats adjacent to it,
                // the seat becomes occupied.
                // 2) If a seat is occupied (#) and four or more seats adjacent to it are also occupied, the seat becomes empty.
                // 3) Otherwise, the seat's state does not change.
                val surrounding = surroundingIndices
                    .map {
                        val (xd, yd) = it
                        var loc = index
                        var first: Char? = '.'
                        while (first == '.') {
                            loc += (xd + yd * width)
                            first = prev.getOrNull(loc)
                        }
                        first
                    }
                    .count { it == '#' }

                if (s == 'L' && surrounding == 0) '#'
                else if (s == '#' && surrounding >= 5) 'L'
                else s
            }
        }
        return cur.count { it == '#' }
    }
}
