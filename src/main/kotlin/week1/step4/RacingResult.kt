package week1.step3

data class RacingResult(val result: MutableList<MutableList<Int>>) {
    fun getRacingAttemptCount(): Int {
        return result.size
    }

    fun getRacingParticipantsCarCount(): Int {
        return result[0].size
    }

    fun getRacingFinalResult(): MutableList<Int> {
        return result.last()
    }
}
