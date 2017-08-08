package com.itcode.first

import scala.actors.Actor
//import scala.actors.Actor
/**
  * Created by along on 17/8/8 14:25.
  * Email:466210864@qq.com
  */
object ActorDemo {
  def main(args: Array[String]): Unit = {
    //    actorTest
//    val actor = new MyActor3
//    actorMessageTest(actor)
    val actor4 = new MyActor4
    actorMessageTest(actor4)

  }

  private def actorMessageTest(actor: Actor) = {
    actor.start()
    actor ! "start"
    actor ! "stop"
    println("消息发送完成！")
  }

  private def actorReceiveTest = {

  }

  private def actorTest = {
    MyActor1.start()
    MyActor2.start()
  }
}

class MyActor4 extends Actor {
  override def act(): Unit = {
    loop {
      react {
        case "start" =>
          println("starting...")
          Thread.sleep(1000)
          println("started")

        case "stop" =>
          println("stopping...")
          Thread.sleep(1000)
          println("stopped")
      }
    }
  }
}


class MyActor3 extends Actor {
  override def act(): Unit = {
    while (true) {
      receive {
        case "start" =>
          println("starting...")
          Thread.sleep(1000)
          println("started")

        case "stop" =>
          println("stopping...")
          Thread.sleep(1000)
          println("stopped")
      }
    }
  }
}

object MyActor1 extends Actor {
  override def act(): Unit = {
    for (i <- 1 to 10) {
      println("actor-1:" + i)
      Thread.sleep(1000)
    }
  }
}

object MyActor2 extends Actor {
  override def act(): Unit = {
    for (i <- 1 to 10) {
      println("actor-2:" + i)
      Thread.sleep(1000)
    }
  }
}