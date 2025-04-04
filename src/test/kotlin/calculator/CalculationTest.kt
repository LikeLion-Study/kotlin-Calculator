package calculator

import calculator.model.Calculation
import calculator.utils.Const
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculationTest {
    private val calculation = Calculation()
    @Test
    fun `빈 문자열 입력 시 0을 반환한다`() {
        val result = calculation.sequence(emptyList(), emptyList())

        assertThat(result).isEqualTo(Const.INITIAL_DOUBLE_VALUE)
    }

    @Test
    fun `덧셈과 뺄셈만 포함된 수식 계산`() {
        val numbers = listOf(1.0, 2.0, 3.0)
        val operators = listOf("+", "-")

        val result = calculation.sequence(numbers, operators)

        assertThat(result.toInt()).isEqualTo(0)
    }

    @Test
    fun `곱셈과 덧셈 포함 수식 계산`() {
        val numbers = listOf(2.0, 3.0, 4.0)
        val operators = listOf("*", "+")

        val result = calculation.sequence(numbers, operators)

        assertThat(result.toInt()).isEqualTo(10)
    }

    @Test
    fun `곱셈과 나눗셈 포함 수식 계산`() {
        val numbers = listOf(4.0, 5.0, 2.0)
        val operators = listOf("*", "/")

        val result = calculation.sequence(numbers, operators)

        assertThat(result.toInt()).isEqualTo(10)
    }
}