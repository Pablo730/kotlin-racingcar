package week1.step3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import week1.step3.RacingCar.Companion.CAR_FROWARD_RANDOM_BASELINE
import week1.step3.RacingCar.Companion.RACING_CAR_DEFAULT_MOVING_VALUE
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RacingCarTest {
    fun `자동차 경주 대수, 횟수 제공`(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(3, 5),
            Arguments.of(8, 12),
        )
    }

    @ParameterizedTest
    @MethodSource("자동차 경주 대수, 횟수 제공")
    fun `랜덤 기준 값보다 낮은 값이 나온경우 차가 전진하는지 검증`(
        numberOfCars: Int,
        numberOfAttempts: Int,
    ) {
        val racingResult: RacingResult =
            RacingCar(numberOfCars, numberOfAttempts) { CAR_FROWARD_RANDOM_BASELINE - 1 }.racingResult()
        assertEquals(racingResult.getRacingParticipantsCarCount(), numberOfCars)
        assertEquals(racingResult.getRacingAttemptCount(), numberOfAttempts)
        assertTrue(racingResult.result.all { it.all { move -> move == RACING_CAR_DEFAULT_MOVING_VALUE } })
    }

    @ParameterizedTest
    @MethodSource("자동차 경주 대수, 횟수 제공")
    fun `랜덤 기준 값 이상의 값이 나온경우 모든 차가 항상 전진하는지 검증`(
        numberOfCars: Int,
        numberOfAttempts: Int,
    ) {
        val racingResult: RacingResult =
            RacingCar(numberOfCars, numberOfAttempts) { CAR_FROWARD_RANDOM_BASELINE }.racingResult()
        assertEquals(racingResult.getRacingParticipantsCarCount(), numberOfCars)
        assertEquals(racingResult.getRacingAttemptCount(), numberOfAttempts)
        assertTrue(racingResult.getRacingFinalResult().all { move -> move == numberOfAttempts })
    }
}
