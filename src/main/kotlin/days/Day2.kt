package days

class Day2 : Day(2) {

    // Each line gives the password policy and then the password. The password policy indicates the
    // lowest and highest number of times a given letter must appear for the password to be valid.
    // For example, 1-3 a means that the password must contain a at least 1 time and at most 3 times.

    override fun partOne(): Int {
        return inputList
            .filter {
                val (range, letter, password) = it.split(" ", ": ")
                val (min, max) = range.split('-').map(String::toInt)
                val letterChar = letter.single()
                password.count { l -> l == letterChar } in min..max
            }.count()
    }

    override fun partTwo(): Int {
        return inputList
            .filter {
                val (indices, letter, password) = it.split(" ", ": ")
                val (i1, i2) = indices.split('-').map(String::toInt).map(Int::dec)
                val letterChar = letter.single()
                (password[i1] == letterChar) xor (password[i2] == letterChar)
            }.count()
    }

}
