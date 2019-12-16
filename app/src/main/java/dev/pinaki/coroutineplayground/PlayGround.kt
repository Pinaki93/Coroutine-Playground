package dev.pinaki.coroutineplayground

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        // Start a coroutine
        launch {
            println("In start : ${getThreadName()}")
            delay(200)
            println("In ended : ${getThreadName()}")
        }

        run {
            println("Out start: ${getThreadName()}")
//            delay(300) //suspending
            Thread.sleep(300) //blocking
            println("Out ended: ${getThreadName()}")
        }
    }
}

fun getThreadName() = Thread.currentThread().name
