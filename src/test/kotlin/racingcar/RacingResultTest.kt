package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RacingResultTest {

    @Test
    fun `경주가 끝난 이후 우승자를 확인할 수 있다`() {
        val racing = Racing(cars = listOf(Car(name = "pablo")), forwardAttemptCount = 4)
        val racingResult: RacingResult = racing.start(carForwardRandomProvider = { 5 })
        racingResult.findWinners().joinToString(", ") shouldBe "pablo"
    }

    @Test
    fun `우승자는 2명 이상 일 수 있다`() {
        val racing = Racing(cars = listOf(Car(name = "pablo"), Car(name = "step")), forwardAttemptCount = 4)
        val racingResult: RacingResult = racing.start(carForwardRandomProvider = { 5 })
        racingResult.findWinners().joinToString(", ") shouldBe "pablo, step"
    }
}