package com.itcode.first

import scala.collection.immutable.HashSet

/**
  * Created by along on 17/8/7 10:29.
  * Email:466210864@qq.com
  */
object ImmutableCollectTest {
  def main(args: Array[String]): Unit = {
    listTest
//    setTest
  }

  private def setTest = {
    val set1 = new HashSet[Int]()
    //将元素与set1合并生成一个新的set,
    val set2 = set1 + 4
    //set中元素不能重复
    val set3 = set2 ++ Set(5, 6, 7)
    val set4 = Set(1, 3, 4) ++ set2
    println(set4.getClass)
    println(set4)
  }

  private def listTest = {
    val test = 9 :: 5 :: 2 :: Nil
    println(test)
    //创建一个不可变的集合
    val list1 = List(1, 3, 4)
    //将0插入到list1前生成一个新的list
    val list2 = 0 :: list1
    val list3 = list1.::(0)
    val list4 = 0 +: list1
    val list5 = list1.+:(0)
    //将元素添加到list1后面生成一个新的集合
    val list6 = list1 :+ 3
    val list0 = List(44, 55, 66)
    //将两个list合并生成一个新的List
    val list7 = list1 ++ list0
    //将list1插入到list0前生成一个新的集合
    val list8 = list1 ++: list0
    //将list0插入到list1前生成一个新的集合
    val list9 = list1.:::(list0)
    println(list9)
    val it = list9.grouped(4)
    val toList = it.toList
    println("toList:"+toList)
    val flat = toList.flatten
    println("flat:"+flat)
    println(it.toList.flatten)
  }
}
