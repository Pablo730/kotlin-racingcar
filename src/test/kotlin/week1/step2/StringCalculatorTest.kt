package week1.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {
    @Test
    fun `입력된 문자열 검증 - 올바른 문자열 입력`() {
        val stringCalculator: StringCalculator = StringCalculator("3 + 5 * 7 / 2 - 10")
        assertThat(stringCalculator.inputExpression).isEqualTo("3 + 5 * 7 / 2 - 10")
    }

    @Test
    fun `입력된 문자열 검증 - 올바르지 않은 문자열 입력`() {
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
    }
}
