import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {
    val job = launch(Dispatchers.Default) {
        for (i in 1..10) {
            yield()
            //취소가 가능한 시점마다 실행시간을 양보하는 함수
            println("I'm sleeping $i ...")
            Thread.sleep(500L)
        }
    }

    delay(1300L)
    println("main : I'm tired of waiting!")
    job.cancelAndJoin()
    //job에 취소 요청을 보내고 반환 후 메인 종료
    println("main : Now I can quit.")
}