package racingcar.domain

class CarForwardAttempt (private val cars: List<Car>) {
    init {
        require(cars.isNotEmpty()) { Racing.INVALID_RACING_CARS_MESSAGE }
    }
    fun attempt(carForwardRandomProvider: CarForwardRandomProvider): ForwardAttemptResult {
        val updatedCars: List<Car> = cars.map { car ->
            car.forward(carForwardRandomProvider.randomValue())
            car.copy()
        }
        return ForwardAttemptResult(updatedCars)
    }
}