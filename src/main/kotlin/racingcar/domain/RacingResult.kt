package racingcar.domain

data class RacingResult(val forwardAttemptResults: List<ForwardAttemptResult>) {
    init {
        require(forwardAttemptResults.isNotEmpty()) { Racing.INVALID_RACING_CARS_MESSAGE }
    }

    fun findWinners(): List<String> {
        val lastRacingResult: ForwardAttemptResult = forwardAttemptResults.last()
        val maxPosition = lastRacingResult.resultCars.maxOf { it.position }
        return lastRacingResult.resultCars.filter { it.position == maxPosition }.map { it.name }
    }
}
