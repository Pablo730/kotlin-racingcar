package racingcar

class Racing(val cars: List<Car>, private var forwardAttemptCount: Int){
    private var startCheck: Boolean = false
    private var winnerList = mutableListOf<String>()
    private var maxPosition: Int = -1
    init {
        require(cars.isNotEmpty()) { INVALID_RACING_CARS_MESSAGE }
        require(forwardAttemptCount >= FORWARD_ATTEMPT_COUNT_MIN_VALUE) { INVALID_FORWARD_ATTEMPT_COUNT_MESSAGE }
    }

    fun start(condition: Int) {
        require(!startCheck) { RACE_IS_ALREADY_OVER_MESSAGE }
        while (forwardAttemptCount >= FORWARD_ATTEMPT_COUNT_MIN_VALUE) {
            forwardAttempt(condition)
        }
        startCheck = true
    }

    private fun forwardAttempt(condition: Int) {
        require(forwardAttemptCount >= FORWARD_ATTEMPT_COUNT_MIN_VALUE) { ALL_EXHAUSTED_FORWARD_ATTEMPT_MESSAGE }
        cars.forEach { car -> car.forward(condition = condition) }
        forwardAttemptCount--
    }

    fun findWinners(): List<String> {
        cars.forEach { car -> compareMaxPosition(car)}
        return winnerList
    }

    private fun compareMaxPosition(compareCar: Car) {
        if (compareCar.position > maxPosition) {
            winnerList = mutableListOf<String>()
            maxPosition = compareCar.position
            winnerList.add(compareCar.name)
            return
        }
        if (compareCar.position == maxPosition) {
            winnerList.add(compareCar.name)
        }
    }

    companion object {
        const val INVALID_RACING_CARS_MESSAGE: String = "자동차 경주에는 최소 1대 이상 참가하는 자동차가 있어야합니다"
        const val FORWARD_ATTEMPT_COUNT_MIN_VALUE: Int = 1
        const val INVALID_FORWARD_ATTEMPT_COUNT_MESSAGE: String = "자동차 경주에는 최소 1회 이상 전진을 시도 해야합니다"
        const val ALL_EXHAUSTED_FORWARD_ATTEMPT_MESSAGE: String = "전진 시도 횟수를 모두 사용하였습니다"
        const val RACE_IS_ALREADY_OVER_MESSAGE: String = "경주는 이미 끝났습니다"
    }
}