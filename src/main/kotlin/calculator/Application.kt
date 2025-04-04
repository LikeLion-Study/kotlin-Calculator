package calculator

import calculator.controller.Calculator
import calculator.model.Calculation
import calculator.view.InputView
import calculator.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val calculation = Calculation()
    val calculator = Calculator(inputView, outputView, calculation)
    calculator.execute()
}
