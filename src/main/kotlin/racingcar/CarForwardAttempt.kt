package racingcar

class CarForwardAttempt (private val cars: List<Car>) {
    init {
        require(cars.isNotEmpty()) { Racing.INVALID_RACING_CARS_MESSAGE }
    }
    fun attempt(carForwardRandomProvider: () -> Int): ForwardAttemptResult {
        val updatedCars = cars.map { car ->
            car.forward(carForwardRandomProvider())
            Car(car.name, car.position)
        }
        return ForwardAttemptResult(updatedCars)
    }
}