package calculator.view

class InputView {
    fun readFormula(): String {
        val formulaString = readln().trim()
        require(!wrongString.containsMatchIn(formulaString)) { INVALID_STRING_INPUT_ERROR }
        require(!wrongOperator.containsMatchIn(formulaString)) { INVALID_OPERATOR_INPUT_ERROR }
        return formulaString
    }

    companion object {
        private val wrongString = Regex("[^\\d\\s+\\-*/]") // 숫자와 연산자가 아닌 글자
        private val wrongOperator = Regex("[+\\-*/]{2,}")

        private const val INVALID_STRING_INPUT_ERROR = "[ERROR] 문자가 입력됐습니다. 입력 형식을 확인해 주세요."
        private const val INVALID_OPERATOR_INPUT_ERROR = "[ERROR] 잘못된 수식입니다. 입력 형식을 확인해 주세요."
    }
}