package days

import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

data class Ferry (
    val x: Int = 0,
    val y: Int = 0,
    val facing: Int = 0,
    val waypointX: Int = 10,
    val waypointY: Int = -1
)
data class Instruction (
    val action: String,
    val value: Int
    )


class Day12 : Day(12) {

    private var ferry = Ferry()

    private val actions = mapOf<String, (Int, Ferry) -> Ferry>(
        "N" to { arg, ferry -> ferry.copy(y = ferry.y - arg) },
        "S" to { arg, ferry -> ferry.copy(y = ferry.y + arg) },
        "W" to { arg, ferry -> ferry.copy(x = ferry.x - arg) },
        "E" to { arg, ferry -> ferry.copy(x = ferry.x + arg) },
        "L" to { arg, ferry -> ferry.copy(facing = ferry.facing - arg) },
        "R" to { arg, ferry -> ferry.copy(facing = ferry.facing + arg) },
        "F" to { arg, ferry ->
            val rad = Math.toRadians(ferry.facing.toDouble())
            val xd = cos(rad).roundToInt() * arg
            var yd = sin(rad).roundToInt() * arg
            ferry.copy(x = ferry.x + xd, y = ferry.y + yd)
        }
    )

    private val actions2 = mapOf<String, (Int, Ferry) -> Ferry>(
        "N" to { arg, ferry -> ferry.copy(waypointY = ferry.waypointY - arg) },
        "S" to { arg, ferry -> ferry.copy(waypointY = ferry.waypointY + arg) },
        "W" to { arg, ferry -> ferry.copy(waypointX = ferry.waypointX - arg) },
        "E" to { arg, ferry -> ferry.copy(waypointX = ferry.waypointX + arg) },
        "L" to { arg, ferry ->
            val rad = Math.toRadians(-arg.toDouble())
            val newX = ferry.waypointX * cos(rad) - ferry.waypointY * sin(rad);
            val newY = ferry.waypointY * cos(rad) + ferry.waypointX * sin(rad);
            ferry.copy(waypointX = newX.roundToInt(), waypointY = newY.roundToInt())
        },
        "R" to { arg, ferry ->
            val rad = Math.toRadians(arg.toDouble())
            val newX = ferry.waypointX * cos(rad) - ferry.waypointY * sin(rad);
            val newY = ferry.waypointY * cos(rad) + ferry.waypointX * sin(rad);
            ferry.copy(waypointX = newX.roundToInt(), waypointY = newY.roundToInt())
        },
        "F" to { arg, ferry ->
            ferry.copy(x = ferry.x + ferry.waypointX * arg,
                y = ferry.y + ferry.waypointY * arg)
        }
    )

    override fun partOne(): Int {
        val ferry = inputList
            .map { Instruction(it.take(1), it.drop(1).toInt()) }
            .fold(Ferry()) { acc, inst -> actions[inst.action]?.invoke(inst.value, acc) ?: Ferry() }
        return abs(ferry.x) + abs(ferry.y)
    }

    override fun partTwo(): Int {
        val ferry = inputList
            .map { Instruction(it.take(1), it.drop(1).toInt()) }
            .fold(Ferry()) { acc, inst -> actions2[inst.action]?.invoke(inst.value, acc) ?: Ferry() }
        return abs(ferry.x) + abs(ferry.y)
    }
}
//524914924 is too high
//101244 is too low