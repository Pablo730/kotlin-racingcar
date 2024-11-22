package racingcar

class Car(val name: String, val position: Int = DEFAULT_CAR_POSITION) {
    init {
        require(name.length in CAR_NAME_LENGTH_MIN .. CAR_NAME_LENGTH_MAX) { INVALID_CAR_NAME_MESSAGE }
    }

    companion object {
        private const val DEFAULT_CAR_POSITION: Int = 0
        private const val CAR_NAME_LENGTH_MIN: Int = 1
        private const val CAR_NAME_LENGTH_MAX: Int = 5
        const val INVALID_CAR_NAME_MESSAGE: String = "자동차 이름이 빈값이나 5글자를 넘을 수 없습니다"
    }
}