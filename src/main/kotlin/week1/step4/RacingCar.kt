package week1.step4

class RacingCar(
    private val racingCarSettingData: RacingCarSetting,
) {
    private val racingAttempt: RacingResult = RacingResult(mutableListOf())

    fun racingResult(): RacingResult {
        racingAttempt.addRacingAttempt(racingAttempt(racingCarSettingData.cars))
        for (attemptCount in 0 until racingCarSettingData.inputAttemptCount - 1) {
            racingAttempt.addRacingAttempt(racingAttempt(racingAttempt.result[attemptCount]))
        }
        return racingAttempt
    }

    private fun racingAttempt(previousRacing: List<Car>): MutableList<Car> {
        val nextRacing: MutableList<Car> = mutableListOf()
        for (carIndex in 0 until racingCarSettingData.cars.size) {
            val indexCar: Car = previousRacing[carIndex]
            indexCar.carRandomForward()
            nextRacing.add(Car(indexCar.carName, indexCar.position, indexCar.carForwardRandomProvider))
        }
        return nextRacing
    }

    companion object {
    }
}
