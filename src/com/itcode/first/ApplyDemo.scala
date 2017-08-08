package com.itcode.first

/**
  * Created by along on 17/8/8 11:18.
  * Email:466210864@qq.com
  */
object ApplyDemo {
  def main(args: Array[String]): Unit = {
    //调用了Array伴生对象的apply方法
    //def apply(x:Int,xs:Int*): Array[Int]
    //arr1中只胡一个元素5
    val arr1 = Array(5)
    println(arr1.toBuffer)

    //new 了一个长度为5的array，数组里面包含5个null
    var arr2 = new Array[Int](5)
    println(arr2.toBuffer)
  }
}
