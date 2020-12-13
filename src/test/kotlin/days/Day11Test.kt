package days

import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day11Test {

    private val dayEleven = Day11()

    @Test
    fun testPartOne() {
        MatcherAssert.assertThat(dayEleven.partOne(), `is`(37))
    }

    @Test
    fun testPartTwo() {
        MatcherAssert.assertThat(dayEleven.partTwo(), `is`(26))
    }
}