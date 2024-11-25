package racingcar.view

import racingcar.domain.RacingResult


class ResultView {
    fun view(racingResult: RacingResult) {
        println("\n실행 결과")
        for (forwardAttemptResult in racingResult.forwardAttemptResults) {
            for (car in forwardAttemptResult.resultCars) println(car.name + " : " + "-".repeat(car.position))
            println()
        }
        println("\n" + racingResult.findWinners().joinToString(", ") + "가 최종 우승했습니다.")
    }
}