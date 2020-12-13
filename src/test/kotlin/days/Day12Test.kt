package days

import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day12Test {

    private val dayTwelve = Day12()

    @Test
    fun testPartOne() {
        MatcherAssert.assertThat(dayTwelve.partOne(), `is`(5))
    }

    @Test
    fun testPartTwo() {
        MatcherAssert.assertThat(dayTwelve.partTwo(), `is`(8))
    }
}