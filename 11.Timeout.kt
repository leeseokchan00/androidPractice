import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking<Unit> {
    withTimeout(1300L) {
        //withTimeout() 함수를 이용해 타임아웃 조건을 걸어 줄 수 있다.
        //메인함수에서 실행 되었기 때문에 TimeoutCancellationException 발생
        launch {
            try {
                repeat(1000) { i ->
                    println("I'm sleeping $i ...")
                    delay(500L)
                }
            } finally {
                println("main : I'm running finally!")
            }
        }
    }
}