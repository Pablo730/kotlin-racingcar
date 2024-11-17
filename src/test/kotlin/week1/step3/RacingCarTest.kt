package week1.step3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import week1.step3.RacingCar.Companion.CAR_FROWARD_RANDOM_BASELINE
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RacingCarTest {
    fun `자동차 경주 대수, 횟수, 전진 기준 값, 마지막 자동찿 위치 값 제공`(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(3, 5, CAR_FROWARD_RANDOM_BASELINE - 1, 0),
            Arguments.of(8, 12, CAR_FROWARD_RANDOM_BASELINE, 12),
        )
    }

    @ParameterizedTest
    @MethodSource("자동차 경주 대수, 횟수, 전진 기준 값, 마지막 자동찿 위치 값 제공")
    fun `랜덤 기준 값을 기준으로 차가 올바르게 전진하는지 검증`(
        numberOfCars: Int,
        numberOfAttempts: Int,
        carForwardRandomBaseValue: Int,
        validCarPosition: Int,
    ) {
        val racingCarSettingData: RacingCarSettingData =
            RacingCarSettingData(inputNumberOfCars = numberOfCars, inputAttemptCount = numberOfAttempts)

        val racingResult: RacingResult =
            RacingCar(racingCarSettingData = racingCarSettingData) { carForwardRandomBaseValue }.racingResult()

        assertEquals(racingResult.getRacingParticipantsCarCount(), numberOfCars)
        assertEquals(racingResult.getRacingAttemptCount(), numberOfAttempts)
        assertTrue(racingResult.getRacingFinalResult().all { move -> move == validCarPosition })
    }
}
