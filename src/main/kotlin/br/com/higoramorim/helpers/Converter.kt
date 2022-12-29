package br.com.higoramorim.helpers

object Converter {
    fun isNumeric(value1: String?): Boolean {
        if (value1.isNullOrBlank()) return false
        val number = value1.replace(",".toRegex(), ".")

        return number.matches("""[-+]?\d*\.?\d+""".toRegex())
    }

    fun convert2Double(value1: String?): Double {
        if (value1.isNullOrBlank()) return 0.0
        val number = value1.replace(",".toRegex(), ".")
        return if (isNumeric(number)) number.toDouble() else 0.0
    }
}