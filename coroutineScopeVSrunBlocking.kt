import kotlinx.coroutines.*
import java.io.Closeable

class Main {
}

fun main(args: Array<String>) = runBlocking {
    launch {
        delay(200L)
        println("Task from runBlocking")
    }

    coroutineScope {
    //coroutineScope는 runBlocking과 달리 자식들의 종료를 기다리지 않음
        launch {
            delay(500L)
            println("Task from nested launch")
        }
        delay(100L)
        println("Task from coroutine scope")
    }
    println("Coroutine scope is over")
}
