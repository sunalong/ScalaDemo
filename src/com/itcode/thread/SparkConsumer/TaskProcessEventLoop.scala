package com.itcode.thread.SparkConsumer

import java.util
import java.util.concurrent.{Callable, Executors, Future}
import scala.util.Random


class TaskProcessEventLoop(name: String) extends EventLoop[TaskEvent](name) {
  var futureList = new util.ArrayList[Future[TaskEvent]]()
  //  var i = 0;
  val THREAD_NUM_IN_POOL = 3

  //  protected override def onReceive(event: TaskEvent): PartialFunction[TaskEvent, Unit] = {
  protected override def onReceive: PartialFunction[TaskEvent, Unit] = {
    case TaskSubmitted(taskName) => {
      println("收到 " + taskName + " 提交成功消息，开始处理任务...")
      //调用处理任务的线程池来处理任务
      threadPoolWithRetData(TaskSubmitted(taskName))
    }
    case TaskSucceeded(taskName) => {
      println("------收到 " + taskName + " 处理成功的消息\n")
    }
    case TaskFailed(taskName) => {
      println("------收到 " + taskName + " 处理失败的消息\n")
    }
  }

  override def onStart(): Unit = {
    println(" onStart Invoke")

    while (futureList.size() > 0) {
      var futureIterator = futureList.iterator()
      while (futureIterator.hasNext) {
        var future = futureIterator.next()

        if (future.isDone) {
          println("主线程中获取线程池中的线程的返回值：" + futureList.size())
          post(future.get())
          futureIterator.remove()
        } else {
          println("主线程中获取线程池中的线程的返回值：" + futureList.size())
          Thread.sleep(200)
        }
      }
    }

  }

    val threadPool = Executors.newFixedThreadPool(THREAD_NUM_IN_POOL)
  /**
    * 线程池返回数据到主线程
    */
  def threadPoolWithRetData(taskEvent: TaskEvent) = {
    val future: Future[TaskEvent] = threadPool.submit(new MyCallable(taskEvent))
    futureList.add(future)



//    threadPool.shutdown()
  }

  var i = 0;

  class MyCallable(taskEvent: TaskEvent) extends Callable[TaskEvent] {

    //    var taskEvent:TaskEvent
    //    def this (taskEvent: TaskEvent, i: Int) {
    //      this (taskEvent)
    //    }

    override def call(): TaskEvent = {
      println(Thread.currentThread().getName + " 执行任务....")
      Thread.sleep(Random.nextInt(1000 * 2)) //两秒之内处理完任务
      i += 1
      if (i % 2 == 0) {
      println(Thread.currentThread().getName + " 完成任务")
        TaskSucceeded(taskEvent.toString)
      } else {
      println(Thread.currentThread().getName + " 失败任务")
        TaskFailed(taskEvent.toString)
      }
    }
  }

}
