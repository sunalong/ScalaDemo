package com.itcode.first

/**
  * Created by ${USER} on ${DATE} ${HOUR}:${MINUTE}.
  * Email:466210864@qq.com
  */

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello 2World")
    variable
    condition
    blockExpression
    ForRecir
    val r1 = m1(f1)
    println("r1=" + r1)

    val r2 = m1(f2)
    println("r2=" + r2)

    val ret = mReterVoid("fuck")
    println("ret:" + ret)
  }

  private def mReterVoid(name: String): Unit = {
    println("mReterVoid:" + name)
  }

  private def m1(f: (Int, Int) => Int): Int = {
    f(2, 6) + 3
  }

  val f1 = (x: Int, y: Int) => x + y
  val f2 = (a: Int, b: Int) => a * b


  private def ForRecir = {
    //在scala中有for循环和while循环，用for循环比较多
    //for循环语法结构：for(i<- 表达式/数组/集合）

    //for(i<- 表达式），表达式 1 to 5 返回一个Range(区间)
    //每次循环将区间中的一个值赋给i
    for (i <- 1 to 5)
      println("i=" + i)

    //for(i<- 数组)
    val arr = Array("a", "b", "c")
    for (i <- arr)
      println("i=" + i)

    //高级for循环
    //每个生成器都可以带一个条件，注意：if前面没有分号
    for (i <- 1 to 3; j <- 1 to 3 if i != j)
      println("i=" + i + " j=" + j)

    //for推导式：如果for循环的循环体以yield开始，则该循环会构建出一个集合
    //每次迭代生成集合中的一个值
    val v = for (i <- 1 to 5) yield i * 10
    println("v=" + v)
  }

  private def blockExpression = {
    val x = 0
    //在scala中{}中可包含一系列表达式，块中最后一个表达式的值就是块的返回值
    val result = {
      if (x < 0)
        -1
      else if (x >= 1)
        1
      else
        "error"
    }
    println("result:" + result)
  }

  private def condition = {
    val x = 1
    val y = if (x > 0) 1 else -1
    println("y=" + y)

    //支持混合类型表达式
    val z = if (x > 1) 1 else "error"
    println("z=" + z)

    //如果缺失else相当于if(x>2)1 else ()
    val m = if (x > 2) 1
    println("m=" + m)

    //在scala中每个表达式都有值，scala中有个Unit类，写做（），相当于java中的void
    val n = if (x > 2) 1 else ()
    println("n=" + n)

    //if 和else if
    val k = if (x < 0) 0
    else if (x >= 1) 1 else -1
    println("k=" + k)
  }

  def variable = {
    //使用val定义的变量值是不可变的，相当于java中用final修饰的变量
    val i = 1
    //使用var定义的变量是可变得，在scala中鼓励使用val
    var s = "hello"
    //scala编译器会自动推断变量的类型，必要的时候可以指定类型
    //格式是：变量名：类型
    var str: String = "fuckme"
    println("i:" + i + " s:" + s + " str:" + str)
  }
}
