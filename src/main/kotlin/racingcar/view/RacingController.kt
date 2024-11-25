package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Racing

class RacingController() {
    fun start() {
        val inputData: InputData = InputView().view()

        val cars: List<Car> = Cars(inputData.inputCarNames).cars
        val racing = Racing(cars = cars, inputData.inputAttemptCount)

        val zeroToNineRandomIndex: () -> Int = {(0..9).random()}
        ResultView().view(racing.start(carForwardRandomProvider = zeroToNineRandomIndex))
    }
}