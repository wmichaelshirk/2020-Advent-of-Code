package days

import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day15Test {

    private val dayFifteen = Day15()

    @Test
    fun testPartOne() {
        MatcherAssert.assertThat(dayFifteen.partOne(), `is`(436))
    }

    @Test
    fun testPartTwo() {
        MatcherAssert.assertThat(dayFifteen.partTwo(), `is`(175594))
    }
}
