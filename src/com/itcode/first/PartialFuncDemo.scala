package com.itcode.first

import scala.collection.mutable

/**
  * Created by along on 17/8/8 12:35.
  * Email:466210864@qq.com
  */
object PartialFuncDemo {
  def main(args: Array[String]): Unit = {
    println("func1:" + func1("one"))
    println("func2:" + func1("two"))
//    Traversable
    mutable.Queue
  }

  def func1: PartialFunction[String, Int] = {
    case "one" => 1
    case "two" => 2
    case _ => 1
  }

  def func2(num: String): Int = num match {
    case "one" => 1
    case "two" => 2
    case _ => 1
  }
}

