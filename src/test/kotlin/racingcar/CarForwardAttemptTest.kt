package racingcar

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Car
import racingcar.domain.CarForwardAttempt
import racingcar.domain.Racing
import java.lang.IllegalArgumentException

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarForwardAttemptTest {
    @Test
    fun `전진을 시도하는 자동차가 존재하지 않으면 예외가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = Racing.INVALID_RACING_CARS_MESSAGE) {
            CarForwardAttempt(cars = listOf())
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `기준 값이 4 이상이면 모든 자동차가 전진한다`(condition: Int) {
        CarForwardAttempt(listOf(Car(name = "pablo", 3), Car(name = "step", 3)))
            .attempt { condition }.resultCars.forEach { it.position shouldBe 4 }
    }

    @ValueSource(ints = [1, 2, 3])
    @ParameterizedTest
    fun `기준 값이 4 미만이면 모든 자동차가 정지한다`(condition: Int) {
        CarForwardAttempt(listOf(Car(name = "pablo", 3), Car(name = "step", 3)))
            .attempt { condition }.resultCars.forEach { it.position shouldBe 3 }
    }
}