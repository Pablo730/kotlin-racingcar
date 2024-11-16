package week1.step3

class ResultView {
    fun viewRacingResult(updateRacingResult: Array<Array<Int>>) {
        println("실행 결과")
        for (racingAttempt in 0 until updateRacingResult!!.size) {
            for (racingCarIndex in 0 until updateRacingResult!![racingAttempt].size) {
                println("-".repeat(updateRacingResult!![racingAttempt][racingCarIndex]))
            }
            println()
        }
    }
}
