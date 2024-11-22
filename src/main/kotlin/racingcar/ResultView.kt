package racingcar


class ResultView {
    fun view(racing: Racing) {
        println("\n실행 결과")
        for (cars in racing.getForwardAttemptResultList()) {
            for (car in cars) println(car.name + " : " + "-".repeat(car.position))
            println()
        }
        println("\n" + racing.findWinners().joinToString(", ") + "가 최종 우승했습니다.")
    }
}