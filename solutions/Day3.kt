import java.io.File

fun main() {
    Day3.part1()
    Day3.part2()
}

object Day3 {
    fun part1() {
        val banks = File("inputs/day3.txt").readLines()

        var count = 0

        for (bank in banks) {

            var first = 0

            for (i in 0..<bank.length - 1) {
                val value = bank[i].digitToInt()

                if (value > bank[first].digitToInt()) {
                    first = i
                }
            }

            var second = first + 1

            for (i in (first + 1)..<bank.length) {
                val value = bank[i].digitToInt()

                if (value > bank[second].digitToInt()) {
                    second = i
                }
            }

            val value = "${bank[first]}${bank[second]}"

            count += value.toInt()
        }

        println("Part 1: $count")
    }

    fun part2() {
        val banks = File("inputs/day3.txt").readLines()

        var count = 0L

        for (bank in banks) {
            val toKeep = 12
            val toSkip = bank.length - toKeep
            var skipsRemaining = toSkip
            val result = StringBuilder()

            for (i in bank.indices) {
                val current = bank[i]

                while (result.isNotEmpty() &&
                    result.last() < current &&
                    skipsRemaining > 0) {
                    result.deleteAt(result.length - 1)
                    skipsRemaining--
                }

                result.append(current)
            }

            while (skipsRemaining > 0) {
                result.deleteAt(result.length - 1)
                skipsRemaining--
            }

            count += result.toString().toLong()
        }

        println("Part 2: $count")
    }
}