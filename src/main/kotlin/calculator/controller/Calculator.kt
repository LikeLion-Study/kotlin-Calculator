package calculator.controller

import calculator.model.Calculation
import calculator.model.Formula
import calculator.utils.retryInput
import calculator.view.InputView
import calculator.view.OutputView

class Calculator(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val calculation: Calculation,
) {
    fun execute() {
        val (numbers, operators) = getFormula()
        calculate(numbers, operators)
    }

    private fun getFormula(): Pair<List<Int>, List<String>> {
        return retryInput(
            runBlock = {
                outputView.printCalculateMessage()
                val formula = inputView.readFormula().run { Formula(this) }
                formula.converter()
            },
            onError = {
                outputView.printErrorMessage(it)
            }
        )
    }

    private fun calculate(numbers: List<Int>, operators: List<String>) {
        val result = calculation.sequence(numbers, operators)
        outputView.printOperationResults(result)
    }
}
