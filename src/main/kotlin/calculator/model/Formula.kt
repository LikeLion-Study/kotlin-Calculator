package calculator.model

class Formula(
    private val formulaString: String
) {
    init {
        require(!wrongString.containsMatchIn(formulaString)) { INVALID_STRING_INPUT_ERROR }
        require(!wrongOperator.containsMatchIn(formulaString)) { INVALID_OPERATOR_INPUT_ERROR }
        require(DIVIDE_BY_ZERO !in formulaString) { INVALID_DIVIDE_BY_ZERO_ERROR }
    }

    fun converter(): Pair<List<Int>, List<String>> {
        val numbers = number.findAll(formulaString).map { it.value.toInt() }.toList()
        val operators = formulaString.split(number).filter { it.trim().isNotEmpty() }
        if (numbers.isEmpty() && operators.isEmpty()) return emptyList<Int>() to emptyList()
        require(numbers.size > operators.size) { INVALID_OPERATOR_INPUT_ERROR + "dd" }
        return numbers to operators
    }

    companion object {
        private val number = Regex("\\d+")
        private val wrongString = Regex("[^\\d\\s+\\-*/]") // 숫자와 연산자가 아닌 글자
        private val wrongOperator = Regex("[+\\-*/]{2,}")
        private const val DIVIDE_BY_ZERO = "/0"

        private const val INVALID_STRING_INPUT_ERROR = "[ERROR] 문자가 입력됐습니다. 입력 형식을 확인해 주세요."
        private const val INVALID_OPERATOR_INPUT_ERROR = "[ERROR] 잘못된 수식입니다. 입력 형식을 확인해 주세요."
        private const val INVALID_DIVIDE_BY_ZERO_ERROR = "[ERROR] 0으로 나눌 수 없습니다. 입력 형식을 확인해 주세요."
    }
}