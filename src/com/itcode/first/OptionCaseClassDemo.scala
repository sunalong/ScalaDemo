package com.itcode.first

/**
  * Created by along on 17/8/8 12:29.
  * Email:466210864@qq.com
  */
object OptionCaseClassDemo extends App {
  val map = Map("a" -> 11, "b" -> 22)
  val v = map.get("c") match {
    case Some(i) => i
    case None => 0
  }
  println(v)
  //更简单的方式
  val v1 = map.getOrElse("C", 0)
  println(v1)
}
