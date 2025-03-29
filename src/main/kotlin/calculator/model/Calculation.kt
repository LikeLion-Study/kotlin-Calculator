package calculator.model

class Calculation {
    fun sequence(numbers: List<Int>, operators: List<String>): Int {
        if (numbers.isEmpty()) return INITIAL_EMPTY_VALUE

        var result = numbers.first()
        var index = INITIAL_INDEX

        operators.forEach { operator ->
            when(operator) {
                ADDITION -> result += numbers[index++]
                SUBTRACTION -> result -= numbers[index++]
                MULTIPLICATION -> result *= numbers[index++]
                DIVISION -> result /= numbers[index++]
            }
        }
        return result
    }

    fun priority(numbers: List<Int>, operators: List<String>) {}

    companion object {
        const val INITIAL_INDEX = 1
        const val INITIAL_EMPTY_VALUE = 0
        const val ADDITION = "+"
        const val SUBTRACTION = "-"
        const val MULTIPLICATION = "*"
        const val DIVISION = "/"
    }
}