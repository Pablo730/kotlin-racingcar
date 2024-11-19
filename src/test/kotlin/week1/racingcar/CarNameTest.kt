package week1.racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.be
import io.kotest.matchers.should
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarNameTest {
    @ParameterizedTest
    @MethodSource("유효하지 않은 자동차 이름 제공")
    fun `유효하지 않은 자동차 이름 생성 검증`(carName: String) {
        val carNameInitException: IllegalArgumentException = shouldThrow<IllegalArgumentException> { CarName(carName) }
        carNameInitException.message should be(CarName.INVALID_CAR_NAME_LENGTH_MESSAGE)
    }

    companion object {
        @JvmStatic
        fun `유효하지 않은 자동차 이름 제공`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(""),
                Arguments.of("racingCar"),
            )
        }
    }
}
