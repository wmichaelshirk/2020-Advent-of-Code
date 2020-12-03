package days

import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsInstanceOf
import org.hamcrest.core.IsNull
import org.junit.Test

class Day3Test {

    private val dayThree = Day3()

    @Test
    fun testPartOne() {
        MatcherAssert.assertThat(dayThree.partOne(), `is`(7))
    }

    @Test
    fun testPartTwo() {
        MatcherAssert.assertThat(dayThree.partTwo(), `is`(336))
    }
}