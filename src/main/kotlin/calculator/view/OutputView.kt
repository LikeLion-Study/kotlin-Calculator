package calculator.view

class OutputView {
    fun printCalculateMessage() {
        println(CALCULATE_EXECUTE_MESSAGE)
    }

    fun printOperationResults(result: Int) {
        println(RESULT_FORMAT)
    }

    fun printErrorMessage(message: String?) {
        println(message)
    }

    companion object {
        const val CALCULATE_EXECUTE_MESSAGE = "수식을 입력해 주세요."
        const val RESULT_FORMAT = "결과: %d"
    }
}