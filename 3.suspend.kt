import kotlinx.coroutines.*
import java.io.Closeable

class Main {
}

fun main(args: Array<String>) = runBlocking {
    launch {
        doWorld()
    }
    println("Hello,")
}

suspend fun doWorld() {
    delay(1000L)
    println("World!")
}
