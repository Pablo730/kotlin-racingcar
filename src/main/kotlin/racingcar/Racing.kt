package racingcar

class Racing(cars: List<Car>){
    init {
        require(cars.isNotEmpty()) { INVALID_RACING_CAR_LIST_MESSAGE }
    }

    companion object {
        const val INVALID_RACING_CAR_LIST_MESSAGE: String = "자동차 경주에는 최소 1대 이상 참가하는 자동차가 있어야합니다"
    }
}