package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isBlank() {
        assertThat(" ".isBlank()).isEqualTo(true)
        assertThat("\n".isBlank()).isEqualTo(true)
        assertThat("""\n""".isBlank()).isEqualTo(false)
        assertThat("\t".isBlank()).isEqualTo(true)
    }
}
