package week1.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import week1.step2.StringCalculator.Companion.INPUT_CALCULATION_EXPRESSION_ERROR_MESSAGE
import week1.step2.StringCalculator.Companion.NULL_OR_BLANK_ERROR_MESSAGE
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringCalculatorTest {
    fun `유효하지 않은 입력 문자열 제공`(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(null, NULL_OR_BLANK_ERROR_MESSAGE),
            Arguments.of("", NULL_OR_BLANK_ERROR_MESSAGE),
            Arguments.of("  ", NULL_OR_BLANK_ERROR_MESSAGE),
            Arguments.of("1 +", INPUT_CALCULATION_EXPRESSION_ERROR_MESSAGE),
            Arguments.of("1 A 2", INPUT_CALCULATION_EXPRESSION_ERROR_MESSAGE),
            Arguments.of("1 2 * 3 /", INPUT_CALCULATION_EXPRESSION_ERROR_MESSAGE),
            Arguments.of("1 + 2 * /", INPUT_CALCULATION_EXPRESSION_ERROR_MESSAGE),
            Arguments.of("+ / 1 * 2", INPUT_CALCULATION_EXPRESSION_ERROR_MESSAGE),
            Arguments.of("1 * 5 +", INPUT_CALCULATION_EXPRESSION_ERROR_MESSAGE),
            Arguments.of("1 - + 2 3", INPUT_CALCULATION_EXPRESSION_ERROR_MESSAGE),
        )
    }

    @ParameterizedTest
    @MethodSource("유효하지 않은 입력 문자열 제공")
    fun `유효하지 않은 입력 문자열 검증`(
        invalidInputExpression: String?,
        errorMessage: String,
    ) {
        val illegalArgumentException: IllegalArgumentException =
            assertThrows<IllegalArgumentException> { StringCalculator(invalidInputExpression) }
        assertEquals(errorMessage, illegalArgumentException.message)
    }

    @Test
    fun `유효한 입력 문자열 검증`() {
        val stringCalculator: StringCalculator = StringCalculator("3 + 5 * 7 / 2 - 10")
        assertThat(stringCalculator.inputExpression).isEqualTo("3 + 5 * 7 / 2 - 10")
    }

    fun `올바른 계산식 및 계산 결과 제공`(): Stream<Arguments> {
        return Stream.of(
            Arguments.of("1 + 1", 2.0),
            Arguments.of("2 * 2", 4.0),
            Arguments.of("1 + 2 / 3 * 5 - 1", 4, 0),
            Arguments.of("3 - 3 * 2 + 5 / 2", 2.5),
        )
    }

    @ParameterizedTest
    @MethodSource("올바른 계산식 및 계산 결과 제공")
    fun `문자열 계산 결과 검증`(
        validInputExpression: String,
        calculationResult: Double,
    ) {
        val stringCalculator: StringCalculator = StringCalculator(validInputExpression)
        assertThat(stringCalculator.calculateResult()).isEqualTo(calculationResult)
    }
}
