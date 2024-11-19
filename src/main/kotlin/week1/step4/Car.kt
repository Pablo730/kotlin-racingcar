package week1.step4

/*
* 구체와 추상화 사이에 trade off를 적절히 해야한다
* */
class Car(val carName: String, var position: Int, val carForwardRandomProvider: () -> Int) {
    init {
        require(carName.length in 1..CAR_NAME_MAX_LENGTH) { INVALID_CAR_NAME_LENGTH_MESSAGE }
        require(position >= CAR_DEFAULT_POSITION) { INVALID_CAR_POSITION_MESSAGE }
    }

    fun getName(): String {
        return carName
    }

    fun carRandomForward() {
        if (carForwardRandomProvider() >= CAR_FROWARD_RANDOM_BASELINE) {
            position++
        }
    }

    companion object {
        const val INVALID_CAR_NAME_LENGTH_MESSAGE: String = "자동차 이름은 최소 1글자 이상, 5글자를 넘을 수 없습니다"
        const val CAR_NAME_MAX_LENGTH: Int = 5
        const val INVALID_CAR_POSITION_MESSAGE: String = "자동차 위치가 불가능한 위치입니다"
        const val CAR_DEFAULT_POSITION: Int = 0
        const val CAR_FROWARD_RANDOM_MIN: Int = 0
        const val CAR_FROWARD_RANDOM_MAX: Int = 10
        const val CAR_FROWARD_RANDOM_BASELINE: Int = 4
    }
}
