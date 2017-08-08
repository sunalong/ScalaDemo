package com.itcode.first

import scala.actors.{Actor, Future}
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Created by along on 17/8/8 16:20.
  * Email:466210864@qq.com
  * 使用actor多线程来计算每个单词出现个数
  */
object ActorWCDemo {
  def main(args: Array[String]): Unit = {
    val files = Array[String]("/Users/along/ATest/test1.txt", "/Users/along/ATest/test1.txt")
    val receiveFunctureSet = new mutable.HashSet[Future[Any]]()
    val resultList = new ListBuffer[ResultTask]()
    for (f <- files) {
      val actorTask = new ActorTask
      val receiveFunction = actorTask.start() !! SubmitMRTask(f)
      println("receiveFunction:" + receiveFunction)
      receiveFunctureSet.add(receiveFunction) //把Future放到集合中
    }
    while (receiveFunctureSet.size > 0) {
      val availableFunctureSet = receiveFunctureSet.filter(_.isSet) //取出有效的结果，待处理的数据
      for (availableFuncture <- availableFunctureSet) {
        val result = availableFuncture.apply().asInstanceOf[ResultTask] //获取实例，注意要加（），以便调用apply()
        println("availableFuncture result:" + result)
        resultList.append(result) //把各线程的结果加到list中
        receiveFunctureSet.remove(availableFuncture)
      }
    }
    //汇总List中的数据
    val result = resultList.flatMap(_.result).groupBy(_._1).mapValues(_.foldLeft(0)(_ + _._2))
    val toList = result.toList
    val sort = toList.sortBy(_._2).reverse

    println("result:" + result)
    println("toList:" + toList)
    println("sort:" + sort)

  }
}

class ActorTask extends Actor {
  override def act(): Unit = {
    loop {
      react {
        case SubmitMRTask(filename) =>
          val result = Source.fromFile(filename).getLines()
            .flatMap(_.split(" ")).map((_, 1)).toList.groupBy(_._1)
            .mapValues(_.size)
          println("submitTask result:" + result)
          sender ! ResultTask(result)
        case StopTask =>
          exit()
      }
    }
  }
}

case class SubmitMRTask(filename: String)

case class ResultTask(result: Map[String, Int])

case object StopTask