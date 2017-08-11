package com.itcode.rpc

import java.util.UUID

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

/**
  * Created by along on 17/8/9 12:19.
  * Email:466210864@qq.com
  */
class Worker(val masterHost: String, val masterPort: Int) extends Actor {
  var master: ActorSelection = _
  val workerId = UUID.randomUUID().toString
  var deviceInfo = "Mac 10.11.6 EI Capitan " + System.currentTimeMillis()

  override def preStart(): Unit = {
    println("Worker preStart")
    master = context.actorSelection(s"akka.tcp://${Master.actorName}@$masterHost:$masterPort/user/MyMaster")
    master ! RegisterWorker(workerId, deviceInfo)
  }

  override def receive: Receive = {
    case RegistedStatus(masterUrl, isSuccess) =>
      println(s"RegistedStatus:$isSuccess,$masterUrl")
  }
}

object Worker {


  def main(args: Array[String]): Unit = {
    val clientHost = args(0)
    val clientPort = args(1).toInt
    val masterHost = args(2)
    val masterPort = args(3).toInt
    val actorName = "WorkerSystem"
    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$clientHost"
         |akka.remote.netty.tcp.port = "$clientPort"
     """.stripMargin
    val config = ConfigFactory.parseString(configStr)
    val actorSystem = ActorSystem(actorName, config)
    actorSystem.actorOf(Props(new Worker(masterHost, masterPort)), "MyWorker")
    actorSystem.awaitTermination()
  }
}

//case class RegisterWorker(id:String)