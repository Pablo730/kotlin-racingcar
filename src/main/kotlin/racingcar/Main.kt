package racingcar

fun main () {
    val inputData: InputData = InputView().view()

    val cars: List<Car> = inputData.inputCarNames.split(",").map { inputCarName -> Car(inputCarName) }
    val racing = Racing(cars = cars, inputData.inputAttemptCount)

    ResultView().view(racing.start(carForwardRandomProvider = { (0..9).random() }))
}