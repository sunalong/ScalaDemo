package com.itcode.first

import scala.util.Random

/**
  * Created by along on 17/8/8 12:22.
  * Email:466210864@qq.com
  * 样例类demo
  */
object CaseClassDemo extends App {
  val arr = Array(CheckTimeOutTask, HeartBeat(12345), SubmitTask("001id", "tasksubmit"))
  arr(Random.nextInt(arr.length)) match {
    case SubmitTask(id, name) => {
      println(s"SubmitTask(id:$id, name:$name)")
    }
    case HeartBeat(time) => {
      println("heartBeat:" + time)
    }
    case CheckTimeOutTask => {
      println("checkTimeTask")
    }
  }
}

case class SubmitTask(id: String, name: String)

case class HeartBeat(time: Long)

case object CheckTimeOutTask