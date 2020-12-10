package days

import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day9Test {

    private val dayNine = Day9()

    @Test
    fun testPartOne() {
        MatcherAssert.assertThat(dayNine.partOne(), `is`(127))
    }

//    @Test
//    fun testPartTwo() {
//        MatcherAssert.assertThat(dayNine.partTwo(), `is`(62))
//    }
}