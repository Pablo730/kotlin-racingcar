package week1.step3

class RacingCar(
    private val racingCarSettingData: RacingCarSettingData,
    private val carForwardRandomProvider: () -> Int,
) {
    private val racingAttempt: RacingResult = RacingResult(mutableListOf())

    private fun racingAttempt(previousRacing: List<Int>): MutableList<Int> {
        val nextRacing: MutableList<Int> = mutableListOf()
        for (carIndex in 0 until racingCarSettingData.inputNumberOfCars) {
            val previousPosition: Int =
                if (previousRacing.size == racingCarSettingData.inputNumberOfCars) previousRacing[carIndex] else 0
            nextRacing.add(previousPosition + carForwardRandom())
        }
        return nextRacing
    }

    private fun carForwardRandom(): Int {
        return if (carForwardRandomProvider() >= CAR_FROWARD_RANDOM_BASELINE) {
            RACING_CAR_FROWARD_VALUE
        } else {
            RACING_CAR_DEFAULT_MOVING_VALUE
        }
    }

    fun racingResult(): RacingResult {
        racingAttempt.result.add(racingAttempt(listOf()))
        for (attemptCount in 0 until racingCarSettingData.inputAttemptCount - 1) {
            racingAttempt.addRacingAttempt(racingAttempt(racingAttempt.result[attemptCount]))
        }
        return racingAttempt
    }

    companion object {
        const val CAR_FROWARD_RANDOM_MIN: Int = 0
        const val CAR_FROWARD_RANDOM_MAX: Int = 10
        const val CAR_FROWARD_RANDOM_BASELINE: Int = 4
        const val RACING_CAR_DEFAULT_MOVING_VALUE: Int = 0
        const val RACING_CAR_FROWARD_VALUE: Int = 1
    }
}
