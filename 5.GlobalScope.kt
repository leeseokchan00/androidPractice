import kotlinx.coroutines.*
import java.io.Closeable

fun main(args: Array<String>) = runBlocking {
    GlobalScope.launch {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L)
}
// 1000번 반복하는 코드이지만 메인함수는 그것보다 짧은 시간을 대기하고 종료함
// globalScope의 코루틴은 자신이 속한 프로세스의 종료를 지연시키지 않고 프로세스 종료 시 함께 종료