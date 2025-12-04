import java.io.File

fun main() {
    Day4.part1()
    Day4.part2()
}

object Day4 {
    fun part1() {
        val grid = File("inputs/day4.txt").readLines()

        val locations = mutableSetOf<String>()

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == '@') {
                    locations.add("$row:$col")
                }
            }
        }

        val removed = mutableSetOf<String>()

        for (location in locations) {
            val split = location.split(":")

            val row = split[0].toInt()
            val col = split[1].toInt()

            var count = 0

            for (adjacent in getAdjacentLocations(row, col)) {
                if (adjacent in locations) {
                    count++
                }
            }

            if (count < 4) {
                removed.add(location)
            }
        }

        println("Part 1: ${removed.size}")
    }

    fun part2() {
        val grid = File("inputs/day4.txt").readLines()

        val locations = mutableSetOf<String>()

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == '@') {
                    locations.add("$row:$col")
                }
            }
        }

        val removed = mutableSetOf<String>()
        var currentRemoved = mutableSetOf<String>()

        while (removed.size == 0 || currentRemoved.size != removed.size) {
            currentRemoved = removed.toMutableSet()

            for (location in locations) {
                if (location in removed) continue

                val split = location.split(":")
                val row = split[0].toInt()
                val col = split[1].toInt()

                var count = 0

                for (adjacent in getAdjacentLocations(row, col)) {
                    if (adjacent in locations && adjacent !in removed) {
                        count++
                    }
                }

                if (count < 4) {
                    removed.add(location)
                }
            }
        }

        println("Part 2: ${removed.size}")
    }

    private fun getAdjacentLocations(row: Int, col: Int): List<String> {
        return listOf(
            "${row - 1}:${col - 1}",
            "${row - 1}:${col}",
            "${row - 1}:${col + 1}",
            "${row}:${col - 1}",
            "${row}:${col + 1}",
            "${row + 1}:${col - 1}",
            "${row + 1}:${col}",
            "${row + 1}:${col + 1}"
        )
    }
}