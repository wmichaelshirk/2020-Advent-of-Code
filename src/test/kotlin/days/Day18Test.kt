package days

import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day18Test {

    private val dayEighteen = Day18()

    @Test
    fun testPartOne() {
        MatcherAssert.assertThat(dayEighteen.partOne(), `is`(13632))
    }

//    @Test
//    fun testPartTwo() {
//        MatcherAssert.assertThat(dayEighteen.partTwo(), `is`(286))
//    }
}