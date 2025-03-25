package calculator

class Calculator {
    fun calculate(input: String): Int {
        // TODO: 코드 구현
        val num = input.split('+', '-', '*', '/')
        println(num.joinToString(" "))
        throw IllegalArgumentException("아직 구현되지 않았습니다.")
    }
}
