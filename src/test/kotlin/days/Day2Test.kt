package days

import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsInstanceOf
import org.hamcrest.core.IsNull
import org.junit.Test

class Day2Test {

    private val dayTwo = Day2()

    @Test
    fun testPartOne() {
        MatcherAssert.assertThat(dayTwo.partOne(), `is`(2))
    }

    @Test
    fun testPartTwo() {
        MatcherAssert.assertThat(dayTwo.partTwo(), `is`(1))
    }
}