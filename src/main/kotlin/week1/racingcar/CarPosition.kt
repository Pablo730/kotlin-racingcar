package week1.racingcar

class CarPosition(private var position: Int = DEFAULT_POSITION) {
    init {
        require(position >= DEFAULT_POSITION) { INVALID_POSITION_MESSAGE }
    }

    fun getPosition(): Int {
        return position
    }

    fun forward() {
        position++
    }

    companion object {
        const val DEFAULT_POSITION: Int = 0
        const val INVALID_POSITION_MESSAGE: String = "불가능한 위치 입니다"
    }
}
