//dispatcher decides in which thread the coroutine will execute// determines the thread of the coroutine

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun main()= runBlocking {

    println("Main thread starts: "+Thread.currentThread().name)

    //println(this)
    //1launch is running on standalondcoroutine and async is on deffered coroutine
     //in launch(context) both coroutine execution is done in main thread, in launch(Dispatchers.Unconfined)  both execution is done on different threads
    launch {

       // println(this)
       // println("fake thread starts: "+Thread.currentThread().name)
       // delay(50)

        //println("fake thread ends: "+Thread.currentThread().name)
        println("C: "+Thread.currentThread().name)
        delay(100)
        println("C after delay: "+Thread.currentThread().name)

//        launch{
//
//            println("child: "+this)
//        }
    }

    // Dispatchers.Default ->c1 excutes on same thread or (same and other thread) after delay //same as globalscope.launch
    //Dispatchers.Unconfined -> first time c2 executes on main thread and second time is on other thread vice versa
    //coroutineContext both c3 is executing on last parent thread

    launch (Dispatchers.Default){

        //println(this)
        println("C1: "+Thread.currentThread().name) // some other thread
        delay(100)
        println("C1 after delay: "+Thread.currentThread().name) // same or some other thread
    }




    launch (Dispatchers.Unconfined){

        //println(this)
        println("C2: "+Thread.currentThread().name) // Main thread
        delay(100)
        println("C2 after delay: "+Thread.currentThread().name) // some other thread


        // here it will be executed on its parents last one's context
        launch (coroutineContext){

            //println(this)
            println("C22: "+Thread.currentThread().name) // run on the thread on which its parent c2 is running
            delay(1000)
            println("C22 after delay: "+Thread.currentThread().name) // run on the thread on which its parent c2 is running


        }
    }

    //its context is runblocking ,,it inherits parent context which is on main thread ...it will be run on main thread// confined dispatcher
    launch (coroutineContext){

          //println(this)
          println("C3: "+Thread.currentThread().name) //main thread
          delay(1000)
          println("C3 after delay: "+Thread.currentThread().name) //main thread
    }

   // delay(1000)

    //run on same or another thread
    launch (Dispatchers.IO){

        //println(this)
        println("C4: "+Thread.currentThread().name) //main thread
        delay(1000)
        println("C4 after delay: "+Thread.currentThread().name) //main thread
    }






    println("Main thread ends: "+Thread.currentThread().name)

}
