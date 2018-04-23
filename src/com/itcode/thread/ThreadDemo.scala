package com.itcode.thread

import java.util
import java.util.concurrent.{Callable, Executors, Future}

import scala.util.Random

object ThreadDemo {
  def main(args: Array[String]): Unit = {
    //    myThreadPool
    threadPoolWithRetData
  }

  /**
    * 线程池返回数据到主线程
    */
  def threadPoolWithRetData = {
    val threadPool = Executors.newFixedThreadPool(3)
    var futureList = new util.ArrayList[Future[String]]()
    for (i <- 1 to 10) {
      val future: Future[String] = threadPool.submit(new CusCallable)
      futureList.add(future)
    }
    while (futureList.size()>0) {
      var itr0 = futureList.iterator();
      while (itr0.hasNext()) {
        var future = itr0.next();
        if (future.isDone) {
          println("主线程中获取线程池中的线程的返回值：" + future.get())
          itr0.remove();
        } else {
          println("主线程中获取线程池中的线程的返回值：" + futureList.size())
          Thread.sleep(1000)
        }
      }
    }
    threadPool.shutdown()
  }

  class CusCallable extends Callable[String] {
    override def call() = {
      println(Thread.currentThread().getName + " 执行任务...")
      Thread.sleep(Random.nextInt(3000))
      "=====" + Thread.currentThread().getName + " 执行任务后返回的数据"
    }
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
