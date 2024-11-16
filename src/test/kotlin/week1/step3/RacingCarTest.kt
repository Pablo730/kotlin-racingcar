package week1.step3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RacingCarTest {
    fun `자동차 경주 대수, 횟수 제공`(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(3, 5),
            Arguments.of(8, 12),
            Arguments.of(5, 7),
            Arguments.of(4, 2),
            Arguments.of(11, 3),
            Arguments.of(2, 3),
        )
    }

    @ParameterizedTest
    @MethodSource("자동차 경주 대수, 횟수 제공")
    fun `자동차 경주 대수 및 횟수에 따른 결과 검증`(
        numberOfCars: Int,
        numberOfAttempts: Int,
    ) {
        val racingAttempt: Array<Array<Int>> = RacingCar(numberOfCars, numberOfAttempts).racingResult()
        assertEquals(racingAttempt.size, numberOfAttempts)
        assertEquals(racingAttempt[0].size, numberOfCars)
        for (attemptIndex in racingAttempt.indices) {
            for (carIndex in racingAttempt[attemptIndex].indices) {
                assertTrue(racingAttempt[attemptIndex][carIndex] in 0..numberOfAttempts)
            }
        }
    }
}
