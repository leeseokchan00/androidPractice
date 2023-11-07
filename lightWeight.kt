import kotlinx.coroutines.*
import java.io.Closeable

class Main {
}

fun main(args: Array<String>) = runBlocking {
    repeat(100_000) {
        launch {
            delay(1000L)
            print(".")
        }
    }
}
// 10만개의 점을 출력하는 코드
// thread로 실행하면 메모리 부족 오류를 발생시켰을 것이지만 coroutine은 출력가능