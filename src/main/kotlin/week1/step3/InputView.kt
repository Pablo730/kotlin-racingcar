package week1.step3

class InputView {
    var numberOfCars: Int = 0
    var numberOfAttempts: Int = 0

    private fun inputNumberOfCars() {
        println("자동차 대수는 몇 대인가요? ")
        numberOfCars = readLine()!!.toInt()
    }

    private fun inputAttemptCount() {
        println("시도할 횟수는 몇 회인가요? ")
        numberOfAttempts = readLine()!!.toInt()
    }

    fun view() {
        inputNumberOfCars()
        inputAttemptCount()
    }
}
