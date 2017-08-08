package com.itcode.first

import scala.util.Random

/**
  * Created by along on 17/8/8 11:28.
  * Email:466210864@qq.com
  */
object CaseDemoStr {
  def main(args: Array[String]): Unit = {
    val arr = Array("firstStr", "secondStr", "thirdStr")
    val name = arr(Random.nextInt(arr.length))
    name match {
      case "firstStr" => println(name + " case")
      case "secondStr" => println(name + " case")
      case _ => println(name + " allcase")
    }

  }
}
