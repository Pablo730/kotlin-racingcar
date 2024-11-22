package racingcar

import racingcar.Car.Companion.CAR_NAME_LENGTH_MAX
import racingcar.Car.Companion.CAR_NAME_LENGTH_MIN
import racingcar.Car.Companion.INVALID_CAR_NAME_MESSAGE

class InputView {
    private fun inputCarNames(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val inputCarNames: String? = readlnOrNull()
        requireNotNull(inputCarNames) { "자동차 이름이 입력되지 않았습니다" }
        require(inputCarNames.isNotBlank()) { "자동차 이름이 올바르게 입력되지 않았습니다" }
        return inputCarNames
    }

    private fun inputAttemptCount(): Int {
        println("시도할 횟수는 몇 회인가요? ")
        val inputAttemptCount: Int? = readlnOrNull()?.toIntOrNull()
        requireNotNull(inputAttemptCount) { "시도할 횟수가 올바르게 입력되지 않았습니다" }
        return inputAttemptCount.toInt()
    }

    fun view(): InputData {
        return InputData(inputCarNames = inputCarNames(), inputAttemptCount = inputAttemptCount())
    }
}