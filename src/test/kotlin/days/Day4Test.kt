package days

import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsInstanceOf
import org.hamcrest.core.IsNull
import org.junit.Test

class Day4Test {

    private val dayFour = Day4()

    @Test
    fun testPartOne() {
        MatcherAssert.assertThat(dayFour.partOne(), `is`(2))
    }

//    @Test
//    fun testPartTwo() {
//        MatcherAssert.assertThat(dayFour.partTwo(), `is`(336))
//    }
}