package calculator.view

import calculator.utils.Const

class OutputView {
    fun printCalculateMessage() {
        println(CALCULATE_EXECUTE_MESSAGE)
    }

    fun printOperationResults(result: Double) {
        when (result % DIVISIBLE_NUMBER) {
            Const.INITIAL_DOUBLE_VALUE -> println(INTEGER_CALCULATE_RESULT.format(result.toInt()))
            else -> println(DECIMAL_CALCULATE_RESULT.format(result))
        }
    }

    fun printErrorMessage(message: String?) {
        println(message)
    }

    companion object {
        const val CALCULATE_EXECUTE_MESSAGE = "수식을 입력해 주세요."
        const val DECIMAL_CALCULATE_RESULT = "결과: %.1f"
        const val INTEGER_CALCULATE_RESULT = "결과: %d"
        const val DIVISIBLE_NUMBER = 1
    }
}