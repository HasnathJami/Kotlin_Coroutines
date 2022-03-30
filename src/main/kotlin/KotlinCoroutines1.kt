//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.launch
import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main()
{
//    println("Main program starts: ${Thread.currentThread().name}")
//
//    thread {
//
//        println("Fake works starts: ${Thread.currentThread().name}")
//        Thread.sleep(1000)  //pretend doing some work.... maybe file upload...etc
//        println("Fake works ends: ${Thread.currentThread().name}")
//    }
//
//    println("Main program ends: ${Thread.currentThread().name}")


//    println("Main program starts: ${Thread.currentThread().name}")
//
//    GlobalScope.launch{   // creates a background coroutines that runs on a background thread
//
//        println("Fake works starts: ${Thread.currentThread().name}")
//        Thread.sleep(500)  //pretend doing some work.... maybe file upload...etc// problem occurs when more coroutines operate within same thread..this will block thread ..which violate the rule of coroutines as other other coroutines can not be performed excluding this... delay(1000) should be used as it does not block the thread on which it is operating
//        println("Fake works ends: ${Thread.currentThread().name}")
//    }
//    Thread.sleep(1000) // blocks the current main thread & waits for coroutine to finish(practically not a right way to wait) //this statement is useless for real project as we do not know the time of operation so its useless to wait with a specific time
//
//    println("Main program ends: ${Thread.currentThread().name}")

//    ////Apporach 1
//    println("Main program starts: ${Thread.currentThread().name}")
//
//    GlobalScope.launch {
//
//         println("Fake works starts: ${Thread.currentThread().name}")
//         delay(1000) //coroutine c1 is suspended but  Thread T1 is free(not blocked)
//         println("Fake works ends: ${Thread.currentThread().name}") //Either T1 or some other thread
//    }
//    runBlocking {// creates a new coroutine that blocks the current main thread
//        delay(2000)  // delay is suspend function, it can not be used outside the coroutine and the solution is wrep it in runBlocking{} block (practically not a right way to wait)
//                // waits for coroutines to finish
//    }
//    println("Main program ends ${Thread.currentThread().name}")


    //Approach 2
//    runBlocking {
//
//        println("Main program starts: ${Thread.currentThread().name}")
//
//        GlobalScope.launch {
//
//            println("Fake works starts: ${Thread.currentThread().name}")
//            delay(1000) //coroutine c1 is suspended but  Thread T1 is free(not blocked)
//            println("Fake works ends: ${Thread.currentThread().name}") //Either T1 or some other thread
//        }
//        // creates a new coroutine that blocks the current main thread
//        delay(2000)  // delay is suspend function, it can not be used outside the coroutine and the solution is wrep it in runBlocking{} block (practically not a right way to wait)
//        // waits for coroutines to finish
//        println("Main program ends ${Thread.currentThread().name}")
//
//    }


    //Approach 4
    runBlocking {

        println("Main program starts: ${Thread.currentThread().name}")

        GlobalScope.launch {

            println("Fake works starts: ${Thread.currentThread().name}")
            setTimeDelay(1000)
             println("Fake works ends: ${Thread.currentThread().name}") //Either T1 or some other thread
        }
        // creates a new coroutine that blocks the current main thread
        setTimeDelay(2000)
        // waits for coroutines to finish
        println("Main program ends ${Thread.currentThread().name}")

    }



}

// approach 4

suspend fun setTimeDelay(time:Long):Unit
{
    delay(time)
}

//// Approach 3
//
//fun main()= runBlocking {
//
//    println("Main program starts: ${Thread.currentThread().name}")
//
//    GlobalScope.launch {
//
//        println("Fake works starts: ${Thread.currentThread().name}")
//        delay(1000) //coroutine c1 is suspended but  Thread T1 is free(not blocked)
//        println("Fake works ends: ${Thread.currentThread().name}") //Either T1 or some other thread
//    }
//    // creates a new coroutine that blocks the current main thread
//    delay(2000)  // delay is suspend function, it can not be used outside the coroutine and the solution is wrep it in runBlocking{} block (practically not a right way to wait)
//    // waits for coroutines to finish
//    println("Main program ends ${Thread.currentThread().name}")
//}