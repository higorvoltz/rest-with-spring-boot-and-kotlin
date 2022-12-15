package br.com.higoramorim

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value = "", defaultValue = "hello world") name: String?): Greeting{
        return Greeting(counter.incrementAndGet(), content = "$name")
    }
}