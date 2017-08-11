package com.itcode.implic

/**
  * Created by along on 17/8/11 15:16.
  * Email:466210864@qq.com
  */
class Pair[T <: Comparable[T]] {
  def comparePair(first: T, second: T): T = {
    if (first.compareTo(second) > 0) first else second
  }
}
object Pair{
  def main(args: Array[String]): Unit = {
    val pStr = new Pair[String]
    println(pStr.comparePair("fuck","lala"))

//    传入Int会报错，因为Int没有实现 Comparable接口
//    但Integer实现了 Comparable 接口，所以传入 Integer可比较
//    val pInt = new Pair[Int]
    val pInt = new Pair[Integer]
    println(pInt.comparePair(11,22))
  }
}