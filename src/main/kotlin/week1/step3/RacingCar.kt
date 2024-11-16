package week1.step3

import kotlin.random.Random

class RacingCar(val numberOfCars: Int, val numberOfAttempts: Int) {
    fun carForwardRandom(): Int {
        return if (Random.nextInt(0, 10) >= 4) 1 else 0
    }

    fun racingAttempt(previousRacing: Array<Int>?): Array<Int> {
        val nextRacing: Array<Int> = Array(numberOfCars) { 0 }
        for (carIndex in 0 until numberOfCars) {
            nextRacing[carIndex] = (previousRacing?.get(carIndex) ?: 0) + carForwardRandom()
        }
        return nextRacing
    }

    fun racingResult(): Array<Array<Int>> {
        val racingAttempt: Array<Array<Int>> = Array(numberOfAttempts) { Array(numberOfCars) { 0 } }
        racingAttempt[0] = racingAttempt(previousRacing = null)
        for (attemptCount in 0 until numberOfAttempts - 1) {
            racingAttempt[attemptCount + 1] = racingAttempt(racingAttempt[attemptCount])
        }
        return racingAttempt
    }
}
