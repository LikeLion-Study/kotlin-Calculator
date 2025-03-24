package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun `빈 문자열 입력 시 0을 반환한다`() {
        val result = calculator.calculate("")
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `덧셈과 뺄셈만 포함된 수식 계산`() {
        val result = calculator.calculate("1+2-3")
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `곱셈과 덧셈 포함 수식 계산`() {
        val result = calculator.calculate("2*3+4")
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `잘못된 수식 입력 시 예외 발생`() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.calculate("1++2")
        }
    }

    // TODO: 테스트 코드 추가 가능합니다.
}
