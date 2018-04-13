package com.itcode.thread

import java.util.concurrent.Executors

object ThreadDemo {
  def main(args: Array[String]): Unit = {
    val threadPool_1 = Executors.newFixedThreadPool(2);
    val threadPool_2 = Executors.newFixedThreadPool(4);
    for (i<-1 to 10){
      threadPool_1.execute(new Runnable {
        override def run(): Unit = {
          println(Thread.currentThread().getName+" 执行任务");
          Thread.sleep(1000)
        }
      })

      threadPool_2.execute(new Runnable {
        override def run(): Unit = {
          println(Thread.currentThread().getName+" 执行任务");
          Thread.sleep(1000)
        }
      })
    }
    threadPool_1.shutdown()
    threadPool_2.shutdown()
  }
}
