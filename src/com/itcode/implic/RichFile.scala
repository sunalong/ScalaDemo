package com.itcode.implic

import java.io.File

import scala.io.Source
//当引用下面一条语句后f.read()可生效，此为隐式转换
import MyPredef._

/**
  * Created by along on 17/8/11 14:59.
  * Email:466210864@qq.com
  */
class RichFile(val f:File) {
  def read() = Source.fromFile(f).mkString
}
object RichFile{
  def main(args: Array[String]): Unit = {
    val f = new File("/Users/along/GitHub/ScalaDemo/src/com/itcode/implic/RichFile.scala")
//    val context = new RichFile(f).read()
    val context = f.read();
    println(context)
  }
}