package calculator.model

import calculator.utils.Const


class Calculation {
    fun sequence(numbers: List<Double>, operators: List<String>): Double {
        if (numbers.isEmpty()) return Const.INITIAL_DOUBLE_VALUE
        return arithmetic(numbers, operators)
    }

    fun priority(numbers: List<Double>, operators: List<String>): Double {
        val localOperators = operators.toMutableList()
        val localNumbers = numbers.toMutableList()

        firstOperation(localNumbers, localOperators)
        return arithmetic(localNumbers, localOperators)
    }

    private fun arithmetic(numbers: List<Double>, operators: List<String>): Double {
        var result = numbers.first()
        var index = INITIAL_INDEX

        operators.forEach { operator ->
            when (operator) {
                ADDITION -> result += numbers[++index]
                SUBTRACTION -> result -= numbers[++index]
                MULTIPLICATION -> result *= numbers[++index]
                DIVISION -> result /= numbers[++index]
            }
        }
        return result
    }

    private fun firstOperation(numbers: MutableList<Double>, operators: MutableList<String>) {
        var index = INITIAL_INDEX
        while (index < operators.size) {
            val result = when (operators[index]) {
                MULTIPLICATION -> numbers.removeAt(index) * numbers.removeAt(index)
                DIVISION -> numbers.removeAt(index) / numbers.removeAt(index)
                else -> continue
            }
            numbers.add(index, result)
            operators.removeAt(index)
            index++
        }
    }

    companion object {
        const val INITIAL_INDEX = 0
        const val ADDITION = "+"
        const val SUBTRACTION = "-"
        const val MULTIPLICATION = "*"
        const val DIVISION = "/"
    }
}