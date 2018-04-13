package com.itcode.thread

import java.util.concurrent.{Callable, Executors, Future}

object ThreadDemo {
  def main(args: Array[String]): Unit = {
    //    myThreadPool
    threadPoolWithRetData
  }

  /**
    * 线程池返回数据到主线程
    */
  def threadPoolWithRetData = {
    val threadPool = Executors.newFixedThreadPool(2)
    val future: Future[String] = threadPool.submit(new Callable[String] {
      override def call() = {
        println(Thread.currentThread().getName + " 执行任务并返回数据")
        Thread.sleep(1000 * 2)
        Thread.currentThread().getName + " 执行任务后返回的数据"
      }
    })
    var status = future.isDone
    println(s"task status:$status")

    Thread.sleep(1000 * 3)
    status = future.isDone
    println(s"task status:$status")

    if (status)
      println("主线程中获取线程池中的线程的返回值：" + future.get())
    threadPool.shutdown()
  }

  /**
    * 简单线程池
    */
  private def myThreadPool = {
    val threadPool_1 = Executors.newFixedThreadPool(2);
    val threadPool_2 = Executors.newFixedThreadPool(4);
    for (i <- 1 to 10) {
      threadPool_1.execute(new Runnable {
        override def run(): Unit = {
          println(Thread.currentThread().getName + " 执行任务");
          Thread.sleep(1000)
        }
      })

      threadPool_2.execute(new Runnable {
        override def run(): Unit = {
          println(Thread.currentThread().getName + " 执行任务");
          Thread.sleep(1000)
        }
      })
    }
    threadPool_1.shutdown()
    threadPool_2.shutdown()
  }
}
