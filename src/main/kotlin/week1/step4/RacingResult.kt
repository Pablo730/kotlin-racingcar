package week1.step4

data class RacingResult(val result: MutableList<MutableList<Car>>) {
    fun getRacingCarName(carIndex: Int): String {
        return result[0][carIndex].carName
    }

    fun getRacingCarPosition(
        racingAttemptCount: Int,
        carIndex: Int,
    ): Int {
        return result[racingAttemptCount][carIndex].position
    }

    fun findRacingWinnerCarNames(): List<String> {
        val winnerCarIndex: MutableList<Int> = findRacingWinnerCarIndex()
        return winnerCarIndex.map { index -> result[0][index].carName }
    }

    private fun findRacingWinnerCarIndex(): MutableList<Int> {
        val winnerCarIndex: MutableList<Int> = mutableListOf()
        var winnerPosition: Int = 0
        result.last().forEachIndexed { index, car ->
            if (car.position >= winnerPosition) {
                if (car.position != winnerPosition) {
                    winnerPosition = car.position
                    winnerCarIndex.clear()
                }
                winnerCarIndex.add(index)
            }
        }
        return winnerCarIndex
    }

    fun addRacingAttempt(attemptRacingResult: MutableList<Car>) {
        result.add(attemptRacingResult)
    }
}
