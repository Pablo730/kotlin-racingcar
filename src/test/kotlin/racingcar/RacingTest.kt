package racingcar

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.Racing.Companion.INVALID_FORWARD_ATTEMPT_COUNT_MESSAGE
import racingcar.Racing.Companion.INVALID_RACING_CARS_MESSAGE
import java.lang.IllegalArgumentException

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RacingTest {
    @Test
    fun `자동차 경주에 참여하는 자동차가 존재하지 않으면 예외가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_RACING_CARS_MESSAGE) {
            Racing(cars = listOf(), forwardAttemptCount = 1)
        }
    }

    @ValueSource(ints = [-1, 0])
    @ParameterizedTest
    fun `자동차 경주의 전진 시도 횟수가 1 미만이면 예외가 발생한다`(forwardAttemptCount: Int) {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_FORWARD_ATTEMPT_COUNT_MESSAGE) {
            Racing(cars = listOf(Car("Pablo")), forwardAttemptCount = forwardAttemptCount)
        }
    }
}