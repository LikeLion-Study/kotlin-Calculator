package calculator.controller

import calculator.model.Formula
import calculator.utils.retryInput
import calculator.view.InputView
import calculator.view.OutputView

class Calculator(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun execute() {
        val (numbers, operators) = getFormula()

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
}
