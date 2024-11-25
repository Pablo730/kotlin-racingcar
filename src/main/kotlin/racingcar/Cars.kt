package racingcar

data class Cars(val carNames: String) {
    val cars: List<Car> = carNames.split(DEFAULT_CAR_NAMES_DELIMITER).map { carName -> Car(name = carName)}

    companion object {
        const val DEFAULT_CAR_NAMES_DELIMITER: String = ","
    }
}