package week1.racingcar

class CarName(private val name: String) {
    init {
        require(name.length in CAR_NAME_LENGTH_MIN..CAR_NAME_LENGTH_MAX) { INVALID_CAR_NAME_LENGTH_MESSAGE }
    }

    fun getName(): String {
        return name
    }

    companion object {
        const val CAR_NAME_LENGTH_MIN: Int = 1
        const val CAR_NAME_LENGTH_MAX: Int = 5
        const val INVALID_CAR_NAME_LENGTH_MESSAGE: String = "자동차 이름은 최소 1글자, 최대 5글자까지 허용됩니다"
    }
}
