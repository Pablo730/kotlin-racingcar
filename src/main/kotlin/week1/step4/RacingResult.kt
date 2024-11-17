package week1.step4

data class RacingResult(val result: MutableList<MutableList<Car>>) {
    fun getRacingAttemptCount(): Int {
        return result.size
    }

    fun getRacingParticipantsCarCount(): Int {
        return result[0].size
    }

    fun getRacingFinalResult(): MutableList<Car> {
        return result.last()
    }
}
