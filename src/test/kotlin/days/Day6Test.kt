package days

import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsInstanceOf
import org.hamcrest.core.IsNull
import org.junit.Test

class Day6Test {

    private val daySix = Day6()

    @Test
    fun testPartOne() {
        MatcherAssert.assertThat(daySix.partOne(), `is`(11))
    }

    @Test
    fun testPartTwo() {
        MatcherAssert.assertThat(daySix.partTwo(), `is`(6))
    }
}