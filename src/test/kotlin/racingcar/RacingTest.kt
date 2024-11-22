package racingcar

import io.kotest.assertions.throwables.shouldThrowWithMessage
import org.junit.jupiter.api.Test
import racingcar.Racing.Companion.INVALID_RACING_CAR_LIST_MESSAGE
import java.lang.IllegalArgumentException

class RacingTest {
    @Test
    fun `자동차 경주에 참여하는 자동차가 존재하지 않으면 예외가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_RACING_CAR_LIST_MESSAGE) {
            Racing(cars = listOf()) }
    }
}