package racingcar

class Car(val name: String, val position: Int = DEFAULT_CAR_POSITION) {

    companion object {
        private const val DEFAULT_CAR_POSITION: Int = 0
    }
}