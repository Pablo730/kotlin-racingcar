package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import racingcar.Car.Companion.INVALID_CAR_NAME_MESSAGE

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
}