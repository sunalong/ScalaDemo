package com.itcode.first

import scala.actors.Actor
//import scala.actors.Actor
/**
  * Created by along on 17/8/8 14:25.
  * Email:466210864@qq.com
  */
object ActorDemo {
  def main(args: Array[String]): Unit = {
    MyActor1.start()
    MyActor2.start()
  }
}

object MyActor1 extends Actor {
  override def act(): Unit ={
    for(i<- 1 to 10){
      println("actor-1:"+i)
      Thread.sleep(1000)
    }
  }
}
object MyActor2 extends Actor {
  override def act(): Unit ={
    for(i<- 1 to 10){
      println("actor-2:"+i)
      Thread.sleep(1000)
    }
  }
}