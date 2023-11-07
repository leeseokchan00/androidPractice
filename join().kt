import kotlinx.coroutines.*
import java.io.Closeable

class Main {
}

fun main(args: Array<String>) = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    //job.join()     
    //모든 코루틴은 각자의 스코프를 가지기 때문에 join()을 호출하지 않아도 자식코루틴이 종료될 때까지 대기
}
