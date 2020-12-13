package days

import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day10Test {

    private val dayTen = Day10()

    @Test
    fun testPartOne() {
        MatcherAssert.assertThat(dayTen.partOne(), `is`(35))
    }

    @Test
    fun testPartTwo() {
        MatcherAssert.assertThat(dayTen.partTwo(), `is`(8))
    }
}