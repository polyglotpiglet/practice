data class Ship @JvmOverloads constructor(val direction: Direction, val length: Int, val row: Int = 0, val column: Int = 0, val destroyed: Boolean = false) {

    val coordinates: Pair<Int, Int> = Pair(row, column)

    fun destroy(): Ship {
        return Ship(direction, length, row, column, true)
    }

}
