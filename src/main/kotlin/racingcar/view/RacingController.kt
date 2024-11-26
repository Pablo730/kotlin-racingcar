package racingcar.view

import racingcar.domain.Car
import racingcar.domain.CarForwardRandomProvider
import racingcar.domain.Cars
import racingcar.domain.Racing

class RacingController() {
    fun start() {
        val inputData: InputData = InputView().view()

        val racing = Racing(Cars(inputData.inputCarNames).cars, inputData.inputAttemptCount)

        ResultView().view(racing.start(carForwardRandomProvider = CarForwardRandomProvider()))
    }
}