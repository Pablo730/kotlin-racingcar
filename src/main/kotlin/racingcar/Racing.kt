package racingcar

class Racing(val cars: List<Car>, private val forwardAttemptCount: Int){
    init {
        require(cars.isNotEmpty()) { INVALID_RACING_CARS_MESSAGE }
        require(forwardAttemptCount > 0) { INVALID_FORWARD_ATTEMPT_COUNT_MESSAGE }
    }

    companion object {
        const val INVALID_RACING_CARS_MESSAGE: String = "자동차 경주에는 최소 1대 이상 참가하는 자동차가 있어야합니다"
        const val INVALID_FORWARD_ATTEMPT_COUNT_MESSAGE: String = "자동차 경주에는 최소 1회 이상 전진을 시도 해야합니다"
    }
}