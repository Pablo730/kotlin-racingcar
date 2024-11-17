package week1.step4

class RacingCar(
    private val racingCarSettingData: RacingCarSettingData,
    private val carForwardRandomProvider: () -> Int,
) {
    companion object {
        const val CAR_FROWARD_RANDOM_MIN: Int = 0
        const val CAR_FROWARD_RANDOM_MAX: Int = 10
        const val CAR_FROWARD_RANDOM_BASELINE: Int = 4
        const val RACING_CAR_DEFAULT_MOVING_VALUE: Int = 0
        const val RACING_CAR_FROWARD_VALUE: Int = 1
    }

    private val racingAttempt: RacingResult = RacingResult(mutableListOf())

    private fun carForwardRandom(): Int {
        return if (carForwardRandomProvider() >= CAR_FROWARD_RANDOM_BASELINE) {
            RACING_CAR_FROWARD_VALUE
        } else {
            RACING_CAR_DEFAULT_MOVING_VALUE
        }
    }

    private fun racingAttempt(previousRacing: List<Car>): MutableList<Car> {
        val nextRacing: MutableList<Car> = mutableListOf()
        for (carIndex in 0 until racingCarSettingData.cars.size) {
            val indexCar: Car = previousRacing[carIndex]
            nextRacing.add(Car(indexCar.carName, indexCar.position + carForwardRandom()))
        }
        return nextRacing
    }

    fun racingResult(): RacingResult {
        racingAttempt(racingCarSettingData.cars)
        for (attemptCount in 0 until racingCarSettingData.cars.size - 1) {
            racingAttempt.result.add(racingAttempt(racingAttempt.result[attemptCount]))
        }
        return racingAttempt
    }
}
