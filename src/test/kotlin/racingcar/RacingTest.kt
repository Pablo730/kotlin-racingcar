package racingcar

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.Racing.Companion.INVALID_FORWARD_ATTEMPT_COUNT_MESSAGE
import racingcar.Racing.Companion.INVALID_RACING_CARS_MESSAGE
import racingcar.Racing.Companion.RACE_IS_ALREADY_OVER_MESSAGE
import java.lang.IllegalArgumentException
import java.util.stream.Stream

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

    @MethodSource("무작위 condition 4 이상 값, 시도 횟수 제공")
    @ParameterizedTest
    fun `레이싱을 시작하면 모든 자동차들이 무작위 값이 4 이상이면 전진을 주어진 횟수만큼 반복 시행한다`
                (condition: Int, forwardAttemptCount: Int) {
        val racing =
            Racing(cars = listOf(Car(name = "pablo"), Car(name = "step")), forwardAttemptCount = forwardAttemptCount)

        racing.start(carForwardRandomProvider = { condition })
        racing.cars.forEach { car -> car.position shouldBe forwardAttemptCount }
    }

    fun `무작위 condition 4 이상 값, 시도 횟수 제공`(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(4, 5),
            Arguments.of(5, 1),
            Arguments.of(6, 2),
            Arguments.of(7, 6),
            Arguments.of(8, 4),
            Arguments.of(9, 3),
        )
    }

    @MethodSource("무작위 condition 4 미만 값, 시도 횟수 제공")
    @ParameterizedTest
    fun `레이싱을 시작하면 모든 자동차들이 무작위 값이 4 미만이면 전진을 주어진 횟수 동안 계속 정지한다`
                (condition: Int, forwardAttemptCount: Int) {
        val racing =
            Racing(cars = listOf(Car(name = "pablo"), Car(name = "step")), forwardAttemptCount = forwardAttemptCount)

        racing.start(carForwardRandomProvider = { condition })
        racing.cars.forEach { car -> car.position shouldBe 0 }
    }

    fun `무작위 condition 4 미만 값, 시도 횟수 제공`(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(1, 5),
            Arguments.of(2, 7),
            Arguments.of(3, 2)
        )
    }

    @Test
    fun `경주가 끝난 이후 경주 재시작을 할 경우 예외가 발생한다`() {
        val racing = Racing(cars = listOf(Car(name = "pablo"), Car(name = "step")), forwardAttemptCount = 4)
        racing.start(carForwardRandomProvider = { 0 })
        shouldThrowWithMessage<IllegalArgumentException>(message = RACE_IS_ALREADY_OVER_MESSAGE) {
            racing.start(carForwardRandomProvider = { 0 })
        }
    }

    @Test
    fun `경주가 끝난 이후 우승자를 확인할 수 있다`() {
        val racing = Racing(cars = listOf(Car(name = "pablo")), forwardAttemptCount = 4)
        racing.start(carForwardRandomProvider = { 5 })
        racing.findWinners().joinToString(", ") shouldBe "pablo"
    }

    @Test
    fun `우승자는 2명 이상 일 수 있다`() {
        val racing = Racing(cars = listOf(Car(name = "pablo"), Car(name = "step")), forwardAttemptCount = 4)
        racing.start(carForwardRandomProvider = { 5 })
        racing.findWinners().joinToString(", ") shouldBe "pablo, step"
    }
}