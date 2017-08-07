package com.itcode.first

/**
  * Created by along on 17/8/6 20:57.
  * Email:466210864@qq.com
  */
object TupleTest {
  def main(args: Array[String]): Unit = {
    //创建元组
    val tup = ("hadoop",3.14,65535)
    println("tup:"+tup)
    //获取元组中的值
    val t,(a,b,c) = tup
    println("t:"+t)
    println("a="+a+" b="+b+" c="+c)
    println((a,b,c))

    println("tup._2:"+tup._2)

    val arr = Array(("tom",88),("jerry",95))
    println("arr.toBuffer:"+arr.toBuffer)
    //将对偶的集合转换成映射
    println("arr.toMap:"+arr.toMap)

    //拉链操作
    val names = Array("tom","jerry","kitty")
    val scores = Array(88,77,99)
    val ns = names.zip(scores)
    println("ns:"+ns.toMap)
  }
}
