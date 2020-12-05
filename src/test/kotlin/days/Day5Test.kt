package days

import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsInstanceOf
import org.hamcrest.core.IsNull
import org.junit.Test

class Day5Test {

    private val dayFive = Day5()

    @Test
    fun testPartOne() {
        MatcherAssert.assertThat(dayFive.partOne(), `is`(357))
    }

//    @Test
//    fun testPartTwo() {
//        MatcherAssert.assertThat(dayFour.partTwo(), `is`(336))
//    }
}