package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual: Person = Person(name = "김창민", age = 20, nickname = "창민")
        assertThat(actual.name).isEqualTo("김창민")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("창민")
    }

    @Test
    fun `널 타입`() {
        val actual: Person = Person(name = "김창민", age = 20, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual: Person = Person(name = "김창민", age = 20)
        assertThat(actual.nickname).isEqualTo("김창민")
    }

    @Test
    fun `데이터 클래스`() {
        val person1: Person = Person(name = "김창민", age = 20)
        person1.temp = "5"
        val person2: Person = Person(name = "김창민", age = 20)
        person2.temp = "4"
        assertThat(person1).isEqualTo(person2)
    }
}
