package racingcar

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Car
import java.lang.IllegalArgumentException
import racingcar.domain.Car.Companion.INVALID_CAR_NAME_MESSAGE

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarTest {
    @Test
    fun `자동차는 이름과 위치를 가진다`() {
        val car = Car(name = "Pablo", position = 3)
        car.name shouldBe "Pablo"
        car.position shouldBe 3
    }

    @Test
    fun `자동차의 초기 위치는 0이다`() {
        val car = Car(name = "Pablo")
        car.position shouldBe 0
    }

    @Test
    fun `자동차의 이름이 빈 값이거나 5글자를 넘으면 예외가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_CAR_NAME_MESSAGE) { Car("") }
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_CAR_NAME_MESSAGE) { Car("NEXT_STEP") }
    }

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `자동차에 주어진 무작위 값이 4 이상이면 전진한다`(condition: Int) {
        val car = Car(name = "Pablo", 2)
        car.forward(condition = condition)
        car.position shouldBe 3
    }

    @ValueSource(ints = [1, 2, 3])
    @ParameterizedTest
    fun `자동차에 주어진 무작위 값이 4 미만이면 정지한다`(condition: Int) {
        val car = Car(name = "Pablo", 2)
        car.forward(condition = condition)
        car.position shouldBe 2
    }
}