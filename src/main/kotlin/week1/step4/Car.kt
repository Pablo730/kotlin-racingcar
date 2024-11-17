package week1.step4

data class Car(val carName: String, val position: Int) {
    init {
        require(carName.length <= CAR_NAME_MAX_LENGTH) { "자동차 이름은 5글자를 넘을 수 없습니다" }
        require(position >= CAR_POSITION_MIN_VALUE) { "자동차 위치가 불가능한 위치입니다" }
    }

    companion object {
        const val CAR_NAME_MAX_LENGTH: Int = 5
        const val CAR_POSITION_MIN_VALUE: Int = 0
    }
}
