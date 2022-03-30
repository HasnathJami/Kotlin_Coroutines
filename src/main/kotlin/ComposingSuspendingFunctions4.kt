import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//fun main()= runBlocking {
//
//    println("Main thread starts: ${Thread.currentThread().name}")
//
//
//    //COde
//
//    val time= measureTimeMillis {
//
//       //1// val one=getMessageOne()
//       //1//val two=getMessageTwo()
//        val one:Deferred<String> = async {     //launch also works in parallel
//
//            "hello"
//            getMessageOne()   //this will return as it is last statment
//
//
//        }// last statement retutn korbe must to remember jodi amra print korte chai kisu
//        val two:Deferred<String> = async{ getMessageTwo() }
//
//        println(one.await() + two.await()) // as async is returning last statment ..we have to fetch this using await()
//    }
//    println("Executing time is= $time ms")
//   // println("${one+two}")
//    println("Main thread finishes: ${Thread.currentThread().name}")
//
//
//}
//
//suspend fun getMessageOne():String{
//
//    delay(1000L)//pretend to do some work for 1sec
//    return "Hello"
//}
//
//
//suspend fun getMessageTwo():String{
//
//    delay(1000L) //pretend to do some work for 1sec
//    return "World!"
//}



//Lazily start coroutine ... for unusing suspend function if we do not use it in our main function


fun main()= runBlocking {

    println("Main thread starts: ${Thread.currentThread().name}")


    //COde
        //1// val one=getMessageOne()
        //1//val two=getMessageTwo(
        val one:Deferred<String> = async(start=CoroutineStart.LAZY) {     //launch also works in parallel
            getMessageOne()   //this will return as it is last statment


        }// last statement retutn korbe must to remember jodi amra print korte chai kisu
        val two:Deferred<String> = async(start=CoroutineStart.LAZY){ getMessageTwo() }

       // println(one.await() + two.await()) // as async is returning last statment ..we have to fetch this using await()


    println("Main thread finishes: ${Thread.currentThread().name}")


}

suspend fun getMessageOne():String{

    delay(1000L)//pretend to do some work for 1sec
    return "Hello"
}


suspend fun getMessageTwo():String{

    delay(1000L) //pretend to do some work for 1sec
    return "World!"
}