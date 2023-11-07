import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {
    val job = launch(Dispatchers.Default) {
        for (i in 1..10) {
            if (!isActive) {
                break
            }
            //isActive: 속성으로 작업 상태가 아니라면 break
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