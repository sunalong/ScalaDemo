package com.itcode.first

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

/**
  * Created by along on 17/8/7 17:03.
  * Email:466210864@qq.com
  */
class MissRight {
  val name = "abc"
  println(name)
  try {
    val context = Source.fromFile("/Users/along/GitHub/ScalaDemo/src/com/itcode/first/MissRight.scala").mkString
    println("context:")
  } catch {
    case e: Exception => e.printStackTrace
  } finally {
    println("finally")
  }

  private var gender = "male"
  //用this关键字定义辅助构造器
  def this(name:String,age:Int,gender:String){
    //每个辅助构造器必须以主构造器或其他的辅助构造器的调用开始
    this()
    println("执行辅助构造器")
    this.gender = gender
  }
}

object MissRight {
  def main(args: Array[String]): Unit = {
    val missRight = new MissRight
    println("missRight:" + missRight)
    val missThis = new MissRight("fuckName",18,"female")
    println("missThis:" + missThis)
  }
}
