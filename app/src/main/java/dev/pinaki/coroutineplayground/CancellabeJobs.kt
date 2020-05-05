package dev.pinaki.coroutineplayground

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        try {

            var i = 0

            while (i < 1000) {
                println("job: I'm sleeping $i ...")
                i++
                if (isActive)
                    delay(500L)
            }
        } catch (e: Exception) {
            // throws kotlinx.coroutines.JobCancellationException
            e.printStackTrace()
        } finally {
            withContext(NonCancellable) {
                println("job: I'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    delay(1300L) // delay a bit

    println("main: I'm tired of waiting!")

    // this can be replaced by cancelAndJoin() extension method
    job.cancel() // cancels the job
    job.join() // waits for job's completion
    println("main: Now I can quit.")
}