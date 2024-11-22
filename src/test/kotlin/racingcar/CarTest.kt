package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

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
}