package week1.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {
    @Test
    fun `입력된 문자열 검증`() {
        assertThrows<IllegalArgumentException> { StringCalculator(null) }
        assertThrows<IllegalArgumentException> { StringCalculator("   ") }
        assertThrows<IllegalArgumentException> { StringCalculator("1 +") }
        assertThrows<IllegalArgumentException> { StringCalculator("1 2 3") }
        assertThrows<IllegalArgumentException> { StringCalculator("+ + +") }
        assertThrows<IllegalArgumentException> { StringCalculator("1 A 2") }
        assertThrows<IllegalArgumentException> { StringCalculator("1 2 * 3 /") }
        assertThrows<IllegalArgumentException> { StringCalculator("1 + 2 * /") }
        assertThrows<IllegalArgumentException> { StringCalculator("+ / 1 * 2") }
        assertThrows<IllegalArgumentException> { StringCalculator("1 * 5 +") }
        assertThrows<IllegalArgumentException> { StringCalculator("1 - + 2 3") }
        val stringCalculator: StringCalculator = StringCalculator("3 + 5 * 7 / 2 - 10")
        assertThat(stringCalculator.inputExpression).isEqualTo("3 + 5 * 7 / 2 - 10")
    }

    @Test
    fun `덧셈 검증`() {
        val stringCalculator: StringCalculator = StringCalculator("3 + 5 * 7 / 2 - 10")
        assertThat(stringCalculator.addition(1.0, 1.0)).isEqualTo(2.0)
        assertThat(stringCalculator.addition(1.5, -1.0)).isEqualTo(0.5)
    }

    @Test
    fun `뺄셈 검증`() {
        val stringCalculator: StringCalculator = StringCalculator("3 + 5 * 7 / 2 - 10")
        assertThat(stringCalculator.subtraction(1.0, 1.0)).isEqualTo(0.0)
        assertThat(stringCalculator.subtraction(1.5, -1.0)).isEqualTo(2.5)
    }

    @Test
    fun `곱셈 검증`() {
        val stringCalculator: StringCalculator = StringCalculator("3 + 5 * 7 / 2 - 10")
        assertThat(stringCalculator.multiplication(1.0, 1.0)).isEqualTo(1.0)
        assertThat(stringCalculator.multiplication(2.0, 2.0)).isEqualTo(4.0)
    }

    @Test
    fun `나누셈 검증`() {
        val stringCalculator: StringCalculator = StringCalculator("3 + 5 * 7 / 2 - 10")
        assertThat(stringCalculator.division(1.0, 1.0)).isEqualTo(1.0)
        assertThat(stringCalculator.division(5.0, 2.0)).isEqualTo(2.5)
    }
}
