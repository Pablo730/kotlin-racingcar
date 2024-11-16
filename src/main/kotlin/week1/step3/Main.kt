package week1.step3

fun main() {
    val inputView: InputView = InputView()
    inputView.inputNumberOfCars()
    inputView.inputAttemptCount()
    println()

    val racingCar: RacingCar = RacingCar(inputView.numberOfCars, inputView.numberOfAttempts)
    val racingResult: Array<Array<Int>> = racingCar.racingResult()

    val resultView: ResultView = ResultView()
    resultView.updateRacingResult(racingResult)
    resultView.view()
}
