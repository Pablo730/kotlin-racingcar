package week1.step3

class ResultView {
    var racingResult: Array<Array<Int>>? = null

    fun updateRacingResult(updateRacingResult: Array<Array<Int>>) {
        racingResult = updateRacingResult
    }

    fun view() {
        require(!racingResult.isNullOrEmpty())
        println("실행 결과")
        for (racingAttempt in 0 until racingResult!!.size) {
            for (racingCarIndex in 0 until racingResult!![racingAttempt].size) {
                println("-".repeat(racingResult!![racingAttempt][racingCarIndex]))
            }
            println()
        }
    }
}
