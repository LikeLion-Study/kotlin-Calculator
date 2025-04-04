package calculator

import calculator.model.Calculation
import calculator.utils.Const
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.nio.charset.StandardCharsets

class CalculatorTest {
    private val originalIn = System.`in`
    private val originalOut = System.out
    private lateinit var outputStream: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream, true, StandardCharsets.UTF_8.name()))
    }

    @AfterEach
    fun tearDown() {
        System.setIn(originalIn)
        System.setOut(originalOut)
    }

    @Test
    fun `계산기 정상 실행 테스트`() {
        val input = "1+2*3+4*5"
        System.setIn(ByteArrayInputStream(input.toByteArray(StandardCharsets.UTF_8)))

        main()

        val output = outputStream.toString(StandardCharsets.UTF_8.name())
        assertThat(output).contains("수식을 입력해 주세요.")
        assertThat(output).contains("결과: 65")
    }
}
