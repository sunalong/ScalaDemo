package com.itcode.rpc

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

/**
  * Created by along on 17/8/9 12:00.
  * Email:466210864@qq.com
  */
class Master extends Actor {
  println("Maseter constructor invoked")


  override def preStart(): Unit = {
    println("master prestart invoked")

  }

  //用于接收消息
  override def receive: Receive = {
    case "connect" => {
      println("master : a client connected")
      sender ! "master's reply"
    }
    case "selfTest" => {
      println("master : receive selfTest")
    }
  }
}

object Master {
  def main(args: Array[String]): Unit = {
    val host = args(0)
    val port = args(1).toInt
    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$host"
         |akka.remote.netty.tcp.port = "$port"
       """.stripMargin
    val config = ConfigFactory.parseString(configStr)
    //ActorSystem是 主管,辅助创建和监控下面的Actor,是单例的
    val actorSystem = ActorSystem("MasterSystem", config)
    //创建Actor，并起个名字
    val masterActor = actorSystem.actorOf(Props[Master], "Master")
    masterActor ! "selfTest" //发送消息
    //让进程等待着，不结束
    actorSystem.awaitTermination()
  }
}