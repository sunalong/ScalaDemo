package com.itcode.thread.SparkConsumer

import com.itcode.thread.ThreadDemo

import scala.util.Random


class TaskProcessEventLoop(name: String) extends EventLoop[TaskEvent](name) {
  var i = 0;

  //  protected override def onReceive(event: TaskEvent): PartialFunction[TaskEvent, Unit] = {
  protected override def onReceive: PartialFunction[TaskEvent, Unit] = {
    //    println("onReceive")
    case TaskSubmitted(taskName) => {
      println("收到 "+ taskName + " 提交成功消息，开始处理任务...")
      Thread.sleep(Random.nextInt(2000))
      if (i % 2 == 0) {
        println(taskName + " 在子类中处理完成，调用 TaskSucceeded 接口将此消息发送出去")
        post(TaskSucceeded(taskName))
      } else {
        println(taskName + " 在子类中处理未完成，调用 TaskFailed 接口将此消息发送出去")
        post(TaskFailed(taskName))
      }
      i += 1
    }
    case TaskSucceeded(taskName) => {
      println("收到任务 " + taskName + " 处理成功的消息")
    }
    case TaskFailed(taskName) => {
      println("收到任务 " + taskName + " 处理失败的消息")
    }
  }

  override def onStart(): Unit = {
    println(" onStart Invoke")
  }
}
