package com.itcode.first

object testMethod {

  //匿名函数声明形式
  val t1 = () => 333 //声明了一个对象赋给t
  /**
    * 定义一个方法，返回值类型为Unit,
    * 参数名为c,参数类型是一个匿名函数，
    * 这个匿名函数的格式是：空参数，返回值类型为Int
    *
    * @param c
    */
  def testMethod1(c: () => Int): Unit = {
    println("testMethod1:" + c())
  }

  def testMethod2(c: () => Int) {
    println("testMethod2:" + c())
    100
  }

  def testMethod21(c: () => Int) {
    println("testMethod21:" + c())
  }

  def testMethod22(c: () => Int) = {
    println("testMethod22:" + c())
  }

  def testMethod3(c: () => Int) = {
    println("testMethod3:" + c())
    1000
  }

  def testMethod4(c: () => Int): Int = {
    println("testMethod4:" + c())
    1000
  }

  def main(args: Array[String]): Unit = {
    //    println(testMethod1(t))
    //    println(testMethod2(t))
    //    println(testMethod21(t))
    //    println(testMethod22(t))
    //    println(testMethod3(t))
    //    println(testMethod4(t))


    val listA = List(1, 2, 3, 5, 5);
    println(listA./:(0)({
      (sum, num) =>
        println(sum + "\t" + num);
        sum + num
    }));
    listA.foldLeft(0)((sum, i) => sum + i)

    println(listA.reduce(_+_))
    println(listA.reduce( (x,y)=>{println(x+"\t"+y);x+y}))

//     val tuple01 = (1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0);
     val tuple01 = (1,2,3,4,5,6,7,8,9);

     println(tuple01._1)


     println(tuple01._4)

    //    val t = List(1, 2, 3, 5, 5)
    //    println(t./:(0)({
    //      (sum,num)=>println(sum+"\t"+num);
    //        sum+num
    //    }));
  }
}

