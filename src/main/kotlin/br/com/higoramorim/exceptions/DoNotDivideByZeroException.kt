package br.com.higoramorim.exceptions

import java.lang.RuntimeException

class DoNotDivideByZeroException(e: String?): ArithmeticException(e) {
}