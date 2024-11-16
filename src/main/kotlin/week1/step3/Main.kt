package week1.step3

fun main() {
    val inputView: InputView = InputView()
    inputView.view()
    println()

    val racingCar: RacingCar = RacingCar(inputView.numberOfCars, inputView.numberOfAttempts)
    val racingResult: Array<Array<Int>> = racingCar.racingResult()

    ResultView().viewRacingResult(racingResult)
}
