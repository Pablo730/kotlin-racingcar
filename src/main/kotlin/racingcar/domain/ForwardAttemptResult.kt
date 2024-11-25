package racingcar.domain

data class ForwardAttemptResult(val resultCars: List<Car>) {
    init {
        require(resultCars.isNotEmpty()) { Racing.INVALID_RACING_CARS_MESSAGE }
    }
}