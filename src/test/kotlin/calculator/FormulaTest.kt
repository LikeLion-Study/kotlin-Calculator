package calculator

import calculator.model.Formula
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class FormulaTest {
    @ParameterizedTest
    @CsvSource("1+2+3", "3*3/3", "1-2+3*4/5")
    fun `정상 입력시 숫자와 연산자 리스트 반환`(input: String) {
        val formula = Formula(input)
        val (numbers, operators) = formula.converter()

        Assertions.assertTrue(numbers.isNotEmpty())
        Assertions.assertTrue(operators.isNotEmpty())
    }

    @Test
    fun `잘못된 수식 입력 시 예외 발생`() {
        assertThrows(IllegalArgumentException::class.java) {
            Formula("1++2")
        }
    }

    @Test
    fun `문자 입력 시 예외 발생`() {
        assertThrows(IllegalArgumentException::class.java) {
            Formula("1+a")
        }
    }

    @Test
    fun `0으로 나누면 예외 발생`() {
        assertThrows(IllegalArgumentException::class.java) {
            Formula("5/0")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["/3+3", "3+3+"])
    fun `연산자가 맨 앞이나 맨 뒤에 나오면 예외 발생`(input: String) {
        assertThrows(IllegalArgumentException::class.java) {
            Formula(input).apply { converter() }
        }
    }
}