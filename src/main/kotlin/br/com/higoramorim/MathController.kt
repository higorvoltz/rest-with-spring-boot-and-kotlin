package br.com.higoramorim

import br.com.higoramorim.exceptions.DoNotDivideByZeroException
import br.com.higoramorim.exceptions.UnsupportedMathOperationException
import br.com.higoramorim.helpers.Converter
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {
    companion object {
        val converter = Converter
    }

    @RequestMapping(value = ["/sum/{value1}/{value2}"])
    fun sum(
        @PathVariable(value = "value1") value1: String?,
        @PathVariable(value = "value2") value2: String?,
    ): Double {
        if (!converter.isNumeric(value1) || !converter.isNumeric(value2))
            throw UnsupportedMathOperationException("insira valor numérico")
        return converter.convert2Double(value1) + converter.convert2Double(value2)
    }

    @RequestMapping(value = ["/sub/{value1}/{value2}"])
    fun sub(
        @PathVariable(value = "value1") value1: String?,
        @PathVariable(value = "value2") value2: String?,
    ): Double {
        if (!converter.isNumeric(value1) || !converter.isNumeric(value2))
            throw UnsupportedMathOperationException("insira valor numérico")
        return converter.convert2Double(value1) - converter.convert2Double(value2)
    }

    @RequestMapping(value = ["mul/{value1}/{value2}"])
    fun mul(
        @PathVariable(value = "value1") value1: String?,
        @PathVariable(value = "value2") value2: String?,
    ): Double {
        if (!converter.isNumeric(value1) || !converter.isNumeric(value2))
            throw UnsupportedMathOperationException("insira valor numérico")
        return converter.convert2Double(value1) * converter.convert2Double(value2)
    }

    @RequestMapping(value = ["div/{value1}/{value2}"])
    fun div(
        @PathVariable(value = "value1") value1: String?,
        @PathVariable(value = "value2") value2: String?,
    ): Double {
        if (!converter.isNumeric(value1) || !converter.isNumeric((value2)))
            throw UnsupportedMathOperationException("insira valor numérico")
        else if (value2 == "0")
            throw DoNotDivideByZeroException("o denominador não pode ser zero")
        return converter.convert2Double(value1) / converter.convert2Double(value2)
    }

    @RequestMapping(value = ["mean/{value1}/{value2}"])
    fun mean(
        @PathVariable(value = "value1") value1: String?,
        @PathVariable(value = "value2") value2: String?,
    ): Double {
        if (!converter.isNumeric(value1) || !converter.isNumeric(value2))
            throw UnsupportedMathOperationException("insira valor numérico")
        return (converter.convert2Double(value1) + converter.convert2Double(value2)) / 2
    }

    @RequestMapping(value = ["square/{value1}"])
    fun square(
        @PathVariable(value = "value1") value1: String?,
    ): Double {
        if (!converter.isNumeric(value1))
            throw UnsupportedMathOperationException("insira valor numérico")
        return kotlin.math.sqrt(converter.convert2Double(value1))
    }

}