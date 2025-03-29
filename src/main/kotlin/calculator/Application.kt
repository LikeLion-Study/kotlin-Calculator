package calculator

import calculator.controller.Calculator
import calculator.view.InputView
import calculator.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val calculator = Calculator(inputView, outputView)
    calculator.execute()
}
