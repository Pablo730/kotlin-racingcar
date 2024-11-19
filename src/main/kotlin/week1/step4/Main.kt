package week1.step4

fun main() {
    val racingCarSettingData: RacingCarSetting = InputView().view()

    val racingResult: RacingResult =
        RacingCar(racingCarSettingData = racingCarSettingData).racingResult()

    ResultView().viewRacingResult(racingResult)
}
