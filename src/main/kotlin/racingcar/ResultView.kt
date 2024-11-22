package racingcar


class ResultView {
    fun view(racing: Racing) {
        println("\n실행 결과")
        for (forwardAttemptResult in racing.getForwardAttemptResultList()) {
            for (car in forwardAttemptResult.resultCars) println(car.name + " : " + "-".repeat(car.position))
            println()
        }
        println("\n" + racing.findWinners().joinToString(", ") + "가 최종 우승했습니다.")
    }
}