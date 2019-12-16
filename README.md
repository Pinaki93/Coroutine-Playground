# Coroutine Playground
Different code recipes to understand Coroutines

<pre>
#     #                         ###           ######                                                   
#  #  #  ####  #####  #    #     #  #    #    #     # #####   ####   ####  #####  ######  ####   ####  
#  #  # #    # #    # #   #      #  ##   #    #     # #    # #    # #    # #    # #      #      #      
#  #  # #    # #    # ####       #  # #  #    ######  #    # #    # #      #    # #####   ####   ####  
#  #  # #    # #####  #  #       #  #  # #    #       #####  #    # #  ### #####  #           #      # 
#  #  # #    # #   #  #   #      #  #   ##    #       #   #  #    # #    # #   #  #      #    # #    # 
 ## ##   ####  #    # #    #    ### #    #    #       #    #  ####   ####  #    # ######  ####   #### 
</pre>

I intend to keep adding snippets as I keep exploring.


## Blocking vs Suspending
Reference: https://medium.com/@elye.project/understanding-suspend-function-of-coroutines-de26b070c5ed

### Blocking:

```kotlin
launch(coroutineContext) {
    println("In start : ${getThreadName()}")
    delay(200)
    println("In ended : ${getThreadName()}")
}

run {
    println("Out start: ${getThreadName()}")
    Thread.sleep(300) //blocking
    println("Out ended: ${getThreadName()}")
}
```

This snippet when run wil give the result:

<pre>
Out start: main
Out ended: main
In start : main
In ended : main
</pre>
 
This is because `Thread.sleep()` blocks the Thread and the `run` block will execute completely before the control goes inside `launch` block

### Suspending:

```kotlin
launch(coroutineContext) {
    println("In start : ${getThreadName()}")
    delay(200)
    println("In ended : ${getThreadName()}")
}

run {
    println("Out start: ${getThreadName()}")
    delay(300) //suspending
    println("Out ended: ${getThreadName()}")
}
```

This snippet when run wil give the result:

<pre>
Out start: main
Out ended: main
In start : main
In ended : main
</pre>
 
This is because `delay()` is a suspended function and when called, it suspends the execution from the current block `run` while letting the code inside `launch` block to execute before passing the control back to the `run` block and running the code after it  

