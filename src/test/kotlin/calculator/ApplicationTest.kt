package calculator

import calculator.model.Calculation
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    private val calculation = Calculation()

    @Test
    fun `빈 문자열 입력 시 0을 반환한다`() {
        val result = calculation.sequence(emptyList(), emptyList())

        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `덧셈과 뺄셈만 포함된 수식 계산`() {
        val numbers = listOf(1, 2, 3)
        val operators = listOf("+", "-")

        val result = calculation.sequence(numbers, operators)

        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `곱셈과 덧셈 포함 수식 계산`() {
        val numbers = listOf(2, 3, 4)
        val operators = listOf("*", "+")

        val result = calculation.sequence(numbers, operators)

        assertThat(result).isEqualTo(10)
    }
}
