package com.itcode.first

import scala.util.Random

/**
  * Created by along on 17/8/8 11:28.
  * Email:466210864@qq.com
  */
object CaseDemo {
  def main(args: Array[String]): Unit = {
    //    strMatch
    //    typeMatch
    //    arrayMatch
    //    listMatch
    //    tupleMatch
    listMultiMatch
  }

  private def tupleMatch = {
    val tup = (3, 7, 0)
    tup match {
      case (1, x, y) => println(s"1,$x, $y")
      case (_, z, 9) => println(z)
      case _ => println("else")
    }
  }

  /**
    * list匹配
    */
  private def listMatch = {
    val list = List(0, 1, 2)
    list match {
      case 0 :: Nil => println("only 0")
      case x :: y :: Nil => println(s"x:$x y:$y")
      case 0 :: tail => println("0...")
      case _ => println("something else")
    }
  }

  private def listMultiMatch = {
    val list = List(2, 3, "seven")
    //    val list = List(2,3,7)
    for (i <- 0 to list.size - 1)
      list(i) match {
        case i: Int => {
          var caclc = i + 1
          println("i=" + i + "  caclc=" + caclc)
        }
        case i: String => {
          println("i是String:" + i)
        }
      }
  }

  /**
    * 数组匹配
    */
  private def arrayMatch = {
    val arr = Array(0, 3, 5, 7)
    arr match {
      case Array(1, x, y) => println(x + " " + y)
      case Array(0) => println("only 0")
      case Array(0, _*) => println("0...")
      case _ => println("something else")
    }
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
