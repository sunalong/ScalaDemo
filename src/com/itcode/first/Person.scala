package com.itcode.first

/**
  * Created by along on 17/8/7 16:29.
  * Email:466210864@qq.com
  */
class Person {
  val id = "9528"
  var age: Int = 18
  //类私有字段，只能在类的内部使用
  private var name: String = "tansan"
  //对象私有字段，访问权限更加严格，Person类的方法只能访问到当前对象的字段
  private[this] val pet = "cat"
}

object Person {
  def main(args: Array[String]): Unit = {
    val p = new Person
    println("p:" + p)
    println("age:" + p.age + "  name:" + p.name)
    //    p.pet//无法访问到pet
  }
}
