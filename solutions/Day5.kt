import java.io.File

fun main() {
    Day5.part1()
    Day5.part2()
}

object Day5 {
    fun part1() {
        val lines = File("inputs/day5.txt").readLines()

        val ranges = mutableListOf<LongRange>()
        val ingredients = mutableListOf<Long>()

        for (line in lines) {
            if ("-" in line) {
                val split = line.split("-")

                ranges.add(split[0].toLong()..split[1].toLong())
            } else if (line.isNotBlank()) {
                ingredients.add(line.toLong())
            }
        }

        val fresh = mutableSetOf<Long>()

        for (ingredient in ingredients) {
            for (range in ranges) {
                if (ingredient in range) {
                    fresh.add(ingredient)
                    break
                }
            }
        }

        println("Part 1: ${fresh.size}")
    }

    fun part2() {
        val lines = File("inputs/day5.txt").readLines()

        val ranges = mutableListOf<LongRange>()

        for (line in lines) {
            if ("-" in line) {
                val split = line.split("-")
                ranges.add(split[0].toLong()..split[1].toLong())
            }
        }

        var count = 0L

        ranges.sortBy { it.first }

        val mergedRanges = mutableListOf<LongRange>()

        if (ranges.isNotEmpty()) {
            var currentStart = ranges[0].first
            var currentEnd = ranges[0].last

            for (i in 1..<ranges.size) {
                val range = ranges[i]

                if (range.first <= currentEnd + 1) {
                    currentEnd = maxOf(currentEnd, range.last)
                } else {
                    mergedRanges.add(currentStart..currentEnd)
                    currentStart = range.first
                    currentEnd = range.last
                }
            }

            mergedRanges.add(currentStart..currentEnd)
        }

        for (range in mergedRanges) {
            count += range.last - range.first + 1
        }

        println("Part 2: $count")
    }
}