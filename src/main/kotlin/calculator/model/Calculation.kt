package calculator.model

class Calculation {
    fun sequence(numbers: List<Int>, operators: List<String>): Int {
        if (numbers.isEmpty()) return 0

        var result = numbers.first()
        var index = 1

        operators.forEach { operator ->
            when(operator) {
                "+" -> result += numbers[index++]
                "-" -> result -= numbers[index++]
                "*" -> result *= numbers[index++]
                "/" -> result /= numbers[index++]
            }
        }
        return result
    }

    fun priority(numbers: List<Int>, operators: List<String>) {}
}