import kotlinx.coroutines.*

//launch, run blocking and async

//
//fun main()= runBlocking {
//
//    println("Main program starts: ${Thread.currentThread().name}")
//
//    val job: Job =launch {// lauches a new  coroutine without blocking the current thread // job object is coroutine controller
//
//
//        println("Fake works starts: ${Thread.currentThread().name}")
//        delay(1000) //coroutine c1 is suspended but  Thread T1 is free(not blocked)
//        println("Fake works ends: ${Thread.currentThread().name}") //Either T1 or some other thread
//    }
//    // creates a new coroutine that blocks the current main thread
//    //delay(2000)  // delay is suspend function, it can not be used outside the coroutine and the solution is wrep it in runBlocking{} block (practically not a right way to wait)
//    job.join()// finally, it is the write way to wait for coroutines to finish then following line will be executed
//    // waits for coroutines to finish
//    //job.cancel() cancel the coroutine
//    println("Main program ends ${Thread.currentThread().name}")
//}

//async
fun main()= runBlocking {

    println("Main program starts: ${Thread.currentThread().name}")

    val jobDeferred: Deferred<Int> =async {// lauches a new  coroutine without blocking the current thread // job object is coroutine controller


        println("Fake works starts: ${Thread.currentThread().name}")
        delay(1000) //coroutine c1 is suspended but  Thread T1 is free(not blocked)
        println("Fake works ends: ${Thread.currentThread().name}") //Either T1 or some other thread
        15
    }
    // creates a new coroutine that blocks the current main thread
    //delay(2000)  // delay is suspend function, it can not be used outside the coroutine and the solution is wrep it in runBlocking{} block (practically not a right way to wait)
   // job.join()// finally, it is the write way to wait for coroutines to finish then following line will be executed
     val data=jobDeferred.await()  // retrieve the data 15 on this data variable
    // waits for coroutines to finish
    //job.cancel() cancel the coroutine
    println("Main program ends ${Thread.currentThread().name}")
}

//USE of runblocking= used to write testcases to test suspending functions

suspend fun myOwnSuspendingFunction()
{
    delay(1000)
}