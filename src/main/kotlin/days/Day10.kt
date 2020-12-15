package days

import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class Day10 : Day(10) {

    private val inputData = inputList.map(String::toInt).sorted()
    private val fullList = listOf(0) + inputData + listOf(inputData.last() + 3)

    override fun partOne(): Int? {

        val foo = fullList
            .zipWithNext()
            .map { it.second - it.first }
            .groupingBy { it }
            .eachCount()

        return foo[3]?.let { foo[1]?.times(it) }
    }

    override fun partTwo(): Long {
        val foo = fullList
            .asSequence()
            .windowed(3)
            .map { Pair(it[1] - it[0], it[2] - it[1])}
            .map {
                !(it.first == 3 || it.second == 3 || (
                        it.first == 2 && it.second == 2
                        ))
            }
            .fold(listOf<Pair<Boolean, Int>>()) {
                acc, pair -> if (acc.isEmpty()) listOf(Pair(pair, 1))
                else if (acc.last().first == pair) {
                    acc.dropLast(1)
                        .plus(Pair(acc.last().first, acc.last().second + 1))
                } else {
                    acc.plus(Pair(pair, 1))
                }
            }
            .filter { it.first }
            .map { it.second }
            .groupBy { it }

        val power = ((foo[2]?.count() ?: 0) * 2) +
                (foo[1]?.count() ?: 0)
        val number = (2.0).pow(power)
        return (number * ((7.0).pow(foo[3]?.count() ?: 0))).roundToLong()
    }
}
