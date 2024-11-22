package racingcar

class Racing(val cars: List<Car>, private var forwardAttemptCount: Int){
    private var startCheck = false
    private val winnerList = mutableListOf<String>()
    private var maxPosition = Int.MIN_VALUE
    private val forwardAttemptResultList = mutableListOf<List<Car>>()
    init {
        require(cars.isNotEmpty()) { INVALID_RACING_CARS_MESSAGE }
        require(forwardAttemptCount >= FORWARD_ATTEMPT_COUNT_MIN_VALUE) { INVALID_FORWARD_ATTEMPT_COUNT_MESSAGE }
    }

    fun start(carForwardRandomProvider: () -> Int) {
        require(!startCheck) { RACE_IS_ALREADY_OVER_MESSAGE }
        while (forwardAttemptCount >= FORWARD_ATTEMPT_COUNT_MIN_VALUE) {
            forwardAttempt(carForwardRandomProvider)
        }
        startCheck = true
    }

    private fun forwardAttempt(carForwardRandomProvider: () -> Int) {
        require(forwardAttemptCount >= FORWARD_ATTEMPT_COUNT_MIN_VALUE) { ALL_EXHAUSTED_FORWARD_ATTEMPT_MESSAGE }
        cars.forEach { car -> car.forward(condition = carForwardRandomProvider()) }
        forwardAttemptResultList.add(cars.map { car -> Car(car.name, car.position) })
        forwardAttemptCount--
    }

    fun findWinners(): List<String> {
        winnerList.clear()
        cars.forEach { car -> compareMaxPosition(car)}
        return winnerList
    }

    private fun compareMaxPosition(compareCar: Car) {
        if (compareCar.position > maxPosition) {
            winnerList.clear()
            maxPosition = compareCar.position
            winnerList.add(compareCar.name)
            return
        }
        if (compareCar.position == maxPosition) {
            winnerList.add(compareCar.name)
        }
    }

    fun getForwardAttemptResultList (): MutableList<List<Car>> {
        return forwardAttemptResultList
    }

    companion object {
        const val INVALID_RACING_CARS_MESSAGE: String = "자동차 경주에는 최소 1대 이상 참가하는 자동차가 있어야합니다"
        const val FORWARD_ATTEMPT_COUNT_MIN_VALUE: Int = 1
        const val INVALID_FORWARD_ATTEMPT_COUNT_MESSAGE: String = "자동차 경주에는 최소 1회 이상 전진을 시도 해야합니다"
        const val ALL_EXHAUSTED_FORWARD_ATTEMPT_MESSAGE: String = "전진 시도 횟수를 모두 사용하였습니다"
        const val RACE_IS_ALREADY_OVER_MESSAGE: String = "경주는 이미 끝났습니다"
    }
}