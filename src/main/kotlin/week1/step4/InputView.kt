package week1.step3

class InputView {
    private fun inputNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요? ")
        val inputNumberOfCars: Int? = readlnOrNull()?.toIntOrNull()
        requireNotNull(inputNumberOfCars) { "자동차 대수가 올바르게 입력되지 않았습니다" }
        return inputNumberOfCars.toInt()
    }

    private fun inputAttemptCount(): Int {
        println("시도할 횟수는 몇 회인가요? ")
        val inputAttemptCount: Int? = readlnOrNull()?.toIntOrNull()
        requireNotNull(inputAttemptCount) { "시도할 횟수가 올바르게 입력되지 않았습니다" }
        return inputAttemptCount.toInt()
    }

    fun view(): RacingCarSettingData {
        return RacingCarSettingData(inputNumberOfCars(), inputAttemptCount())
    }
}
