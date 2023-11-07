import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            withContext(NonCancellable) {
                //withContext에 NonCancellable 컨텍스트를 전달해서 처리하는 코드
                //withContext: 이미 CancellableException이 발생한 상황에서 다른 중단 함수를 호출해야 하는 상황에 사용
                delay(1000)
                println("main : I'm running finally!")
            }
        }
    }

    delay(1300L)
    println("main : I'm tired of waiting!")
    job.cancelAndJoin()
    println("main : Now I can quit.")
}