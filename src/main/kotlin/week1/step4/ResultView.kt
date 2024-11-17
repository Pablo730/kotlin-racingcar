package week1.step3

class ResultView {
    fun viewRacingResult(updateRacingResult: RacingResult) {
        println("\n실행 결과")
        for (racingAttempt in updateRacingResult.result.indices) {
            for (racingCarIndex in 0 until updateRacingResult.result[racingAttempt].size) {
                println("-".repeat(updateRacingResult.result[racingAttempt][racingCarIndex]))
            }
            println()
        }
    }
}
