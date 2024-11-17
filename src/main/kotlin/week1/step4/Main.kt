package week1.step3

import week1.step3.RacingCar.Companion.CAR_FROWARD_RANDOM_MAX
import week1.step3.RacingCar.Companion.CAR_FROWARD_RANDOM_MIN
import kotlin.random.Random

fun main() {
    val inputView: InputView = InputView()
    val racingCarSettingData: RacingCarSettingData = inputView.view()

    val racingCar: RacingCar =
        RacingCar(racingCarSettingData.inputNumberOfCars, racingCarSettingData.inputAttemptCount) {
            Random.nextInt(CAR_FROWARD_RANDOM_MIN, CAR_FROWARD_RANDOM_MAX)
        }
    val racingResult: RacingResult = racingCar.racingResult()

    ResultView().viewRacingResult(racingResult)
}
