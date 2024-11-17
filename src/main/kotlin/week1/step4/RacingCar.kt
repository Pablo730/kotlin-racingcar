package week1.step3

class RacingCar(
    private val numberOfCars: Int,
    private val numberOfAttempts: Int,
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

    private fun racingAttempt(previousRacing: MutableList<Int>?): MutableList<Int> {
        val nextRacing: MutableList<Int> = mutableListOf()
        for (carIndex in 0 until numberOfCars) {
            nextRacing.add((previousRacing?.get(carIndex) ?: 0) + carForwardRandom())
        }
        return nextRacing
    }

    fun racingResult(): RacingResult {
        racingAttempt.result.add(racingAttempt(null))
        for (attemptCount in 0 until numberOfAttempts - 1) {
            racingAttempt.result.add(racingAttempt(racingAttempt.result[attemptCount]))
        }
        return racingAttempt
    }
}
