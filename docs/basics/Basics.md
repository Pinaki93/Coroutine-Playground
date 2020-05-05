# Basics

Reference: https://kotlinlang.org/docs/reference/coroutines/basics.html

> Essentially, coroutines are light-weight threads. They are launched with launch coroutine builder in a context of some CoroutineScope.

## First Coroutine

```kotlin
fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    Thread.sleep(2000L)
}
```

In the above example, `CoroutineScope` is `GlobalScope`, which will stay alive until the JVM application is alive. The additional `Thread.sleep(2000L)` will keep the JVM application alive until the coroutine is executed


## RunBlocking Coroutine Builder
```kotlin
fun main() = runBlocking<Unit> { // start main coroutine
    GlobalScope.launch { // launch a new coroutine in background and continue
        delay(1000L)
        println("World!")
    }
    println("Hello,") // main coroutine continues here immediately
    delay(2000L)      // delaying for 2 seconds to keep JVM alive
}
```

>> The main thread invoking runBlocking blocks until the coroutine inside runBlocking completes.

>> This is also a way to write unit tests for suspending functions

## Waiting 


