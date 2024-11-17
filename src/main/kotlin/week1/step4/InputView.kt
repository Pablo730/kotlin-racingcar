package week1.step4

class InputView {
    private fun inputRacingCarNames(): List<Car> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val inputRacingCarNames: List<String>? = readlnOrNull()?.split(",")

        requireNotNull(inputRacingCarNames) { "경주할 자동차 이름이 올바르게 입력되지 않았습니다" }

        return inputRacingCarNames.map { inputRacingCarName -> Car(inputRacingCarName, Car.CAR_POSITION_MIN_VALUE) }
    }

    private fun inputAttemptCount(): Int {
        println("시도할 횟수는 몇 회인가요? ")
        val inputAttemptCount: Int? = readlnOrNull()?.toIntOrNull()

        requireNotNull(inputAttemptCount) { "시도할 횟수가 올바르게 입력되지 않았습니다" }

        return inputAttemptCount.toInt()
    }

    fun view(): RacingCarSettingData {
        return RacingCarSettingData(inputRacingCarNames(), inputAttemptCount())
    }
}
