package racingcar

class Racing(val cars: List<Car>, private val forwardAttemptCount: Int) {
    private val carForwardAttempt: CarForwardAttempt = CarForwardAttempt(cars)

    init {
        require(cars.isNotEmpty()) { INVALID_RACING_CARS_MESSAGE }
        require(forwardAttemptCount >= FORWARD_ATTEMPT_COUNT_MIN_VALUE) { INVALID_FORWARD_ATTEMPT_COUNT_MESSAGE }
    }

    fun start(carForwardRandomProvider: () -> Int): RacingResult {
        val forwardAttemptResults = mutableListOf<ForwardAttemptResult>()

        repeat(forwardAttemptCount) {
            val attemptResult = carForwardAttempt.attempt(carForwardRandomProvider)
            forwardAttemptResults.add(attemptResult)
        }
        return RacingResult(forwardAttemptResults)
    }

    companion object {
        const val INVALID_RACING_CARS_MESSAGE: String = "자동차 경주에는 최소 1대 이상 참가하는 자동차가 있어야합니다"
        const val FORWARD_ATTEMPT_COUNT_MIN_VALUE: Int = 1
        const val INVALID_FORWARD_ATTEMPT_COUNT_MESSAGE: String = "자동차 경주에는 최소 1회 이상 전진을 시도 해야합니다"
        const val ALL_EXHAUSTED_FORWARD_ATTEMPT_MESSAGE: String = "전진 시도 횟수를 모두 사용하였습니다"
    }
}
