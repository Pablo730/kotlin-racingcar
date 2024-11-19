package week1.racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.be
import io.kotest.matchers.should
import org.junit.jupiter.api.Test

class CarPositionTest {
    @Test
    fun `유효하지 않은 자동차 위치 생성 검증`() {
        val carNameInitException: IllegalArgumentException =
            shouldThrow<IllegalArgumentException> { CarPosition(-1) }
        carNameInitException.message should be(CarPosition.INVALID_POSITION_MESSAGE)
    }

    @Test
    fun `전진할 경우, 위치 증가 검증`() {
        val carPosition: CarPosition = CarPosition()
        carPosition.forward()
        carPosition.getPosition() should be(1)
        carPosition.forward()
        carPosition.getPosition() should be(2)
    }
}
