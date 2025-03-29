package calculator.view

class OutputView {
    fun printCalculateMessage() {
        println(CALCULATE_EXECUTE_MESSAGE)
    }

    companion object {
        const val CALCULATE_EXECUTE_MESSAGE = "수식을 입력해 주세요."
    }
}