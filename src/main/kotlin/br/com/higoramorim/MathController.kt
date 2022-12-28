package br.com.higoramorim

import br.com.higoramorim.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class MathController {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{value1}/{value2}"])
    fun sum(
        @PathVariable(value = "value1") value1: String?,
        @PathVariable(value = "value2") value2: String?,
    ): Double {
        if (!isNumeric(value1) || !isNumeric(value2))
            throw UnsupportedMathOperationException("insira valor numérico")
        return convert2Double(value1) + convert2Double(value2)
    }

    private fun convert2Double(value1: String?): Double {
        if (value1.isNullOrBlank()) return 0.0
        val number = value1.replace(",".toRegex(), ".")
        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    private fun isNumeric(value1: String?): Boolean {
        if (value1.isNullOrBlank()) return false
        val number = value1.replace(",".toRegex(), ".")

        return number.matches("""[-+]?\d*\.?\d+""".toRegex())
    }
}