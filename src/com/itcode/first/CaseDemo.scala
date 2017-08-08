package com.itcode.first

import scala.util.Random

/**
  * Created by along on 17/8/8 11:28.
  * Email:466210864@qq.com
  */
object CaseDemo {
  def main(args: Array[String]): Unit = {
//    strMatch
    typeMatch
  }

  /**
    * 类型匹配
    */
  private def typeMatch = {
    val arr = Array("hello", 1, 2.0, CaseDemo)
    val v = arr(Random.nextInt(arr.length))
    v match {
      case x: Int => println(x + " Int")
      case y: Double => println(y + " Double")
      case z: String => println(z + " String")
      case _ => throw new Exception("not match exception")
    }
  }

  /**
    * 匹配字符串
    */
  private def strMatch = {
    val arr = Array("firstStr", "secondStr", "thirdStr")
    val name = arr(Random.nextInt(arr.length))
    name match {
      case "firstStr" => println(name + " case")
      case "secondStr" => println(name + " case")
      case _ => println(name + " allcase")
    }
  }
}
