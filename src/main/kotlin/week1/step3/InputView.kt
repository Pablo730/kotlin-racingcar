package week1.step3

class InputView {
    var numberOfCars: Int = 0
    var numberOfAttempts: Int = 0

    fun inputNumberOfCars() {
        println("자동차 대수는 몇 대인가요? ")
        numberOfCars = readLine()!!.toInt()
    }

    fun inputAttemptCount() {
        println("시도할 횟수는 몇 회인가요? ")
        numberOfAttempts = readLine()!!.toInt()
    }
}
