package com.itcode.rpc

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.collection.mutable

/**
  * Created by along on 17/8/9 12:00.
  * Email:466210864@qq.com
  */
class Master(masterHost: String, masterPort: Int) extends Actor {
  println("Maseter constructor invoked")
  var workerIdSet = new mutable.HashSet[String]()
  var workerMap = new mutable.HashMap[String, WorkerInfo]()

  override def preStart(): Unit = {
    println("master prestart invoked")

  }

  //用于接收消息
  override def receive: Receive = {
    case RegisterWorker(id, deviceInfo) => {
      println(s"client($id) come to register,deviceInfo:$deviceInfo")
      if (workerIdSet.contains(id)) {
        println(s"client($id) have already registed before")
      } else {
        workerMap.put(id, new WorkerInfo(id, deviceInfo))
        workerIdSet += id
        sender ! RegistedStatus(s"akka.tcp://${Master.actorName}@$masterHost:$masterPort/user/MyMaster", true)
      }
    }
    case "selfTest" => {
      println("master : receive selfTest")
    }
  }
}

object Master {
  val actorName = "MasterSystem"

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
    val actorSystem = ActorSystem(actorName, config)
    //创建Actor，并起个名字
    val masterActor = actorSystem.actorOf(Props(new Master(host, port)), "MyMaster")
    masterActor ! "selfTest" //发送消息
    //让进程等待着，不结束
    actorSystem.awaitTermination()
  }
}