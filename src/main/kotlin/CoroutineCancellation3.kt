import javafx.application.Application.launch
import kotlinx.coroutines.*
import java.lang.Exception

//Cancellation, Timeouts, and Exception Handling

//isActive remaining to code

//    fun main()= runBlocking {
//
//        println("Main thread starts: ${Thread.currentThread().name}")
//
//
//        val job: Job =launch {
//
//            try{
//
//                for(i in 0..500)
//                {
//                    print("$i ")
//                    // Thread.sleep(50) // use delay() which is under coroutine package and cancellable
//                    delay(50)
//                    //     yield() //faster than delay
//                }
//
//
//
//            }catch(e:Exception)
//            {
//                println("Exception  safely")
//
//            }
//            finally {
//
//                println("Close resource finally")
//            }
//
//
//
//        }
//        delay(10) // lets print some value within 1 sec before cancel
//        println()
//        //job.cancel()
//        //job.join()
//        job.cancelAndJoin()
//
//        println("Main thread finishes: ${Thread.currentThread().name}")
//
//
//    }

     fun main(): Unit =runBlocking {


//         launch {
//
//                 withTimeout(2000)
//                 {
//                     for(i in 0..500)
//                     {
//                         print("$i ")
//                         delay(50)
//                     }
//                 }
//              //  println()
//
//         }


         launch {

            val res= withTimeoutOrNull(1000)
             {
                 for(i in 0..100)
                 {
                     print("$i ")
                     delay(50)
                 }

                 "finished"
             }
             println(res) // return null if not finished within given time. On the other hand, return finished if it is finished within given time
         }


     }








