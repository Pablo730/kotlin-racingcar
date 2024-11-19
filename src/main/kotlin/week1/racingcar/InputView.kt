package week1.racingcar

class InputView {
    fun view(): RacingCarSettingData {
        return RacingCarSettingData(inputNumberOfCars(), inputAttemptCount())
    }

    private fun inputNumberOfCars(): List<CarName> {
        println(INPUT_GUIDE_CAR_NAMES_MESSAGE)
        val inputCarNames: String? = readlnOrNull()
        requireNotNull(inputCarNames) { NOT_NULL_CAR_NAMES_MESSAGE }
        return inputCarNames.split(",").map { inputCarName -> CarName(inputCarName) }
    }

    private fun inputAttemptCount(): Int {
        println(INPUT_GUIDE_ATTEMPT_COUNT_MESSAGE)
        val inputAttemptCount: Int? = readlnOrNull()?.toIntOrNull()
        requireNotNull(inputAttemptCount) { INVALID_ATTEMPT_COUNT_MESSAGE }
        return inputAttemptCount.toInt()
    }

    companion object {
        private const val INPUT_GUIDE_CAR_NAMES_MESSAGE: String = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val INPUT_GUIDE_ATTEMPT_COUNT_MESSAGE: String = "시도할 횟수는 몇 회인가요?"
        const val NOT_NULL_CAR_NAMES_MESSAGE: String = "자동차 이름이 입력되지 않았습니다"
        const val INVALID_ATTEMPT_COUNT_MESSAGE: String = "시도할 횟수는 몇 회인가요?"
    }
}
