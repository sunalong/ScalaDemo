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
    println("context:" + context)
  } catch {
    case e: Exception => e.printStackTrace
  } finally {
    println("finally")
  }
}

object MissRight {
  def main(args: Array[String]): Unit = {
    val missRight = new MissRight
    println("missRight:" + missRight)
  }
}
