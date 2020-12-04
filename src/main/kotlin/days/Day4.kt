package days

typealias Passport = Map<String, String>

class Day4 : Day(4) {


    private val fields = mapOf<String, (String) -> Boolean>(
        "byr" to { p -> p.toIntOrNull() in 1920..2002 },
        "iyr" to { p -> p.toIntOrNull() in 2010..2020 },
        "eyr" to { p -> p.toIntOrNull() in 2020..2030 },
        "hgt" to { p ->
            val (height, unit) = Regex("^([0-9]+)([a-z]+)$")
                .find(p)?.destructured?.toList() ?: listOf("", "")
            when (unit) {
                "cm" -> height.toIntOrNull() in 150..193
                "in" -> height.toIntOrNull() in 59..76
                else -> false
            }
        },
        "hcl" to { p -> Regex("^#[0-9a-f]{6}$") matches p },
        "ecl" to { p -> listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(p) },
        "pid" to { p -> Regex("^[0-9]{9}$") matches p },
        "cid" to { _ -> true }
    )

    private fun strToPassport(string: String): Passport {
        return string.split(Regex("\\s"))
            .map {
                val (k, v) = it.split(":")
                k to v
            }.toMap()
    }

    private fun validate(pass: Passport): Boolean {
        return pass.keys.containsAll(fields.keys.minus("cid")) and pass.all {
            fields[it.key]?.let { it1 -> it1(it.value) } ?: false
        }
    }

    override fun partOne(): Int {
        return inputString.split("\n\n")
            .filter {
                val document = strToPassport(it)
                document.keys.containsAll(fields.keys)
            }.count()
    }

    override fun partTwo(): Int {
        return inputString.split("\n\n")
            .filter {
                val document = strToPassport(it)
                validate(document)
            }.count()
    }
}
