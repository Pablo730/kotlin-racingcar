package racingcar

data class ForwardAttemptResult(val resultCars: List<Car>) {
    init {
        require(resultCars.isNotEmpty()) { "자동차 전진을 시도한 결과로 어떠한 자동차도 존재하지 않습니다" }
    }
}