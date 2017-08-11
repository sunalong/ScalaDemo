package com.itcode.implic

/**
  * Created by along on 17/8/11 15:41.
  * Email:466210864@qq.com
  */

////视图界定：view bound
//必须传进去一个隐式转换的函数
//class Chooser[T <% Ordered[T]] {
//  def choose(first: T, second: T): T = {
//    if (first > second) first else second
//  }
//}

//上下文界定
//必须传进去一个隐式转换的值
class Chooser[T: Ordering] {
  def choose(first: T, second: T): T = {
    val ordering = implicitly[Ordering[T]]
    if (ordering.gt(first, second)) first else second
  }
}

object Chooser {
  def main(args: Array[String]): Unit = {
    import MyPredef._
    val chooser = new Chooser[Girl]
    val g1 = new Girl("angleBaby", 90)
    val g2 = new Girl("hatano", 99)
    val result = chooser.choose(g1, g2)
    println("result:" + result.name)
  }
}

class Girl(val name: String, val faceValue: Int) {

}