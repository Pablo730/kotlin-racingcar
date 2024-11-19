package week1.step4

class ResultView {
    fun viewRacingResult(updateRacingResult: RacingResult) {
        println("\n실행 결과")
        for (racingAttempt in updateRacingResult.result.indices) {
            for (racingCarIndex in 0 until updateRacingResult.result[racingAttempt].size) {
                val carName: String = updateRacingResult.getRacingCarName(carIndex = racingCarIndex)

                val position: Int =
                    updateRacingResult.getRacingCarPosition(
                        carIndex = racingCarIndex,
                        racingAttemptCount = racingAttempt,
                    )

                println(carName + ": " + "-".repeat(position))
            }
            println()
        }
        println(updateRacingResult.findRacingWinnerCarNames().joinToString(",") + "가 최종 우승했습니다.")
    }
}
