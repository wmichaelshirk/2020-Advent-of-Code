package days

import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day14Test {

    private val dayFourteen = Day14()

    @Test
    fun testPartOne() {
        MatcherAssert.assertThat(dayFourteen.partOne(), `is`(165))
    }

    @Test
    fun testPartTwo() {
        MatcherAssert.assertThat(dayFourteen.partTwo(), `is`(208))
    }
}
