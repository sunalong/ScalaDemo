package com.itcode.first

object MethodsTest {
  def m2(a:Int,b:Int){println("a+b=",a+b)}
  def main(args: Array[String]): Unit = {
    val a=3
    val b=4
    Array().toBuffer
    println("a+b=",a+b)//结果为：(a+b=,7)
    println("a+b="+a+b)//结果为：a+b=34
    println("a+b="+(a+b))//结果为：a+b=7
  }

}
