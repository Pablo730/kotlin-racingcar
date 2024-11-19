package week1.step4

import week1.step4.Car.Companion.CAR_DEFAULT_POSITION
import week1.step4.Car.Companion.CAR_FROWARD_RANDOM_MAX
import week1.step4.Car.Companion.CAR_FROWARD_RANDOM_MIN
import kotlin.random.Random

class InputView {
    fun view(): RacingCarSetting {
        return RacingCarSetting(cars = inputCarNames(), inputAttemptCount = inputAttemptCount())
    }

    private fun inputCarNames(): List<Car> {
        println(INPUT_CAR_NAME_MESSAGE)
        val inputCarNames: String? = readlnOrNull()
        requireNotNull(inputCarNames) { INVALID_CAR_NAME_MESSAGE }
        return inputCarNames.split(INPUT_CAR_NAME_DELIMITER).map {
                inputCarName ->
            Car(carName = inputCarName, position = CAR_DEFAULT_POSITION) {
                Random.nextInt(CAR_FROWARD_RANDOM_MIN, CAR_FROWARD_RANDOM_MAX)
            }
        }
    }

    private fun inputAttemptCount(): Int {
        println(INPUT_ATTEMPT_COUNT_MESSAGE)
        val inputAttemptCount: Int? = readln().toIntOrNull()
        requireNotNull(inputAttemptCount) { INVALID_ATTEMPT_COUNT_MESSAGE }
        return inputAttemptCount.toInt()
    }

    companion object {
        const val INPUT_CAR_NAME_MESSAGE: String = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val INPUT_CAR_NAME_DELIMITER: String = ","
        const val INVALID_CAR_NAME_MESSAGE: String = "경주할 자동차 이름이 올바르게 입력되지 않았습니다"
        const val INPUT_ATTEMPT_COUNT_MESSAGE: String = "시도할 횟수는 몇 회인가요?"
        const val INVALID_ATTEMPT_COUNT_MESSAGE: String = "시도할 횟수가 올바르게 입력되지 않았습니다"
    }
}
