import java.io.File

fun main() {
    Day2.part1()
    Day2.part2()
}

object Day2 {
    fun part1() {
        val ranges = File("inputs/day2.txt").readText().split(",")

        var count = 0L

        for (range in ranges) {
            val values = range.split("-").map { it.toLong() }

            val start = values[0]
            val end = values[1]

            for (i in start..end) {
                val str = i.toString()

                if (str.length % 2 != 0) {
                    continue
                }

                val (firstHalf, secondHalf) = str.chunked(str.length / 2)

                if (firstHalf == secondHalf) {
                    count += i
                }
            }
        }

        println("Part 1: $count")
    }

    fun part2() {
        val ranges = File("inputs/day2.txt").readText().split(",")

        var count = 0L

        for (range in ranges) {
            val values = range.split("-").map { it.toLong() }

            val start = values[0]
            val end = values[1]

            for (i in start..end) {
                val str = i.toString()

                for (x in 2..str.length) {
                    if (str.length % x != 0) {
                        continue
                    }

                    val parts = str.chunked(str.length / x)

                    val setOfParts = parts.toSet()

                    if (setOfParts.size == 1) {
                        count += i
                        break
                    }
                }
            }
        }

        println("Part 2: $count")
    }
}