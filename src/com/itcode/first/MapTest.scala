package com.itcode.first

import scala.collection.mutable.Map
/**
  * Created by along on 17/8/6 20:41.
  * Email:466210864@qq.com
  */
object MapTest {
  def main(args: Array[String]): Unit = {
    mapTest
  }

  def mapTest: Unit ={
  //创建map的两行形式
    val scores1 = Map("tom"->98,"jerry"->89,"kitty"->97)
    println("scores1:"+scores1)

    val scores2 = Map(("tom",98),("jerry",89),("kitty",90))
    println("scores2:"+scores2)

    //获取映射中的值
    println("tom:"+scores1("tom"))
    println("tom:"+scores1.getOrElse("tom",22))
    println("Nom:"+scores1.getOrElse("Nom",22))

    //scala中有两种map,一个是immutable包下的map,该map中的内容不可变
    //另一个是mutable包下的map，该map中的内容可变
    scores1("tom")=100
    println("修改后tom:"+scores1("tom"))

    scores1 +=("fuck"->45,"suke"->79)
    println("scores1:"+scores1)
  }
}
