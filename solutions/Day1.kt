import java.io.File

fun main() {
    part1()
    part2()
}

fun part1() {
    val coordinates = File("inputs/day1.txt").readLines()

    var current = 50

    val total = 100

    val max = 99
    val min = 0

    var count = 0

    for (line in coordinates) {
        val operation = line[0]
        val value = line.substring(1).toInt()

        val remainder = value % total

        when (operation) {
            'L' -> {
                current -= remainder

                if (current < min) {
                    current += total
                }
            }

            'R' -> {
                current += remainder

                if (current > max) {
                    current -= total
                }
            }
        }

        if (current == 0) {
            count++
        }
    }

    println("Part 1: $count")
}

fun part2() {
    val coordinates = File("inputs/day1.txt").readLines()

    var current = 50

    val total = 100

    val max = 99
    val min = 0

    var count = 0

    for (line in coordinates) {
        val operation = line[0]
        val value = line.substring(1).toInt()

        val remainder = value % total
        val fullCircles = value / total

        when (operation) {
            'L' -> {
                if (current in 1..remainder) {
                    count++
                }

                current -= remainder
                if (current < min) {
                    current += total
                }
            }

            'R' -> {
                if (current + remainder >= total) {
                    count++
                }

                current += remainder
                if (current > max) {
                    current -= total
                }
            }
        }

        count += fullCircles
    }

    println("Part 2: $count")
}