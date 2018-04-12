package com.itcode.first

object ListTest {
  def main(args: Array[String]): Unit = {
    val list = List(1, 7, 9, 8, 0, 3, 5, 4, 6, 2)
    println("list:" + list)
    val list2 = list.map(_ * 10)
    println("list2:" + list2)
    val list3 = list.filter(_ % 2 == 0)
    println("list3:" + list3)
    val list4 = list.sortWith(_ < _)
    println("list4:" + list4)

    val list5 = list.sortBy(x => x)
    println("list5:" + list5)

    val list6 = list.grouped(4)

    println("list6:" + list6.toList)
    //   list6.toArray
    //    res5: Array[List[Int]] = Array(List(1, 7, 9, 8), List(0, 3, 5, 4), List(6, 2))


    val list7 = list.grouped(4)
    list7.foreach(println)

    val lines0 = List("hello tom hello jerry", "hello jerry", "hello kitty")
    val words = lines0.flatten
    println("words:" + words)


    //    单词统计并排序：
    val lines = List("hello tom hello jerry", "hello jerry", "hello kitty")
    val wordsNum1 = lines.flatMap(_.split(" ")).map((_, 1))
    //    wordsNum: List[(String, Int)] = List((hello,1), (tom,1), (hello,1), (jerry,1), (hello,1), (jerry,1), (hello,1), (kitty,1))

    val wordsNum2 = lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1)
    //    wordsNum: scala.collection.immutable.Map[String,List[(String, Int)]] = Map(tom -> List((tom,1)), kitty -> List((kitty,1)), jerry -> List((jerry,1), (jerry,1)), hello -> List((hello,1), (hello,1), (hello,1), (hello,1)))

    val wordsNum3 = lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).map(t => (t._1, t._2.size))
    //    wordsNum: scala.collection.immutable.Map[String,Int] = Map(tom -> 1, kitty -> 1, jerry -> 2, hello -> 4)

    val wordsNum4 = lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).map(t => (t._1, t._2.size)).toList
    //    wordsNum: List[(String, Int)] = List((tom,1), (kitty,1), (jerry,2), (hello,4))
    val wordsNum5 = lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).map(t => (t._1, t._2.size)).toList.sortBy(_._2)
    //    wordsNum: List[(String, Int)] = List((tom,1), (kitty,1), (jerry,2), (hello,4))

    val wordsNum6 = lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).mapValues(_.foldLeft(0)(_ + _._2))
    //    wordsNum: scala.collection.immutable.Map[String,Int] = Map(tom -> 1, kitty -> 1, jerry -> 2, hello -> 4)
    println(wordsNum6)
//    val wordsNum7 = lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).mapValues(_.fold(0)(_ + _._2))
//    println("wordsNum7:"+wordsNum7)
//    Todo:fold与foldLeft的区别

    val a = prinStr(3)
    val b = prinStr _

    //    println("a:"+a)
    println("b:" + b(33))


    val arr = Array(1, 2, 3, 4, 5)
    arr.reduce(_ + _)
    arr.reduce(_ - _) //串行操作
    //    (((1 - 2) - 3) - 4) - 5
    //并行操作
    val parValue = arr.par.reduce(_ + _)
    println("parValue:" + parValue)

    //柯里化
    arr.foldLeft(10)(_ + _)
    arr.foldLeft(10)(_ - _)
    val parFoldLeftValue = arr.par.foldLeft(10)(_ + _)//无并行效果
    println("parFoldLeftValue:"+parFoldLeftValue)//25

    arr.fold(10)(_ + _)
    val parFoldValue = arr.par.fold(10)(_ + _)//有多线程效果
    println("parFoldValue:"+parFoldValue)//65

  }

  def prinStr(a: Int) = {
    println(a)
    a
  }
}
