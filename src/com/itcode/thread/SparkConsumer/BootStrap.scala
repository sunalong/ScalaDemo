package com.itcode.thread.SparkConsumer

/**
  * 用户入口，用来提交任务给Spark运算
  */
object BootStrap {
  def main(args: Array[String]): Unit = {
    val eventLoop = new TaskProcessEventLoop("task-event-loop")
    eventLoop.start()
    for (i <- 1 to 5)
      eventLoop.post(TaskSubmitted(s"task-$i"))//把任务放到队列中
//    Thread.sleep(3000)
  }

}
