/**
  * Created by ${USER} on ${DATE} ${HOUR}:${MINUTE}.
  * Email:466210864@qq.com
  */

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello 2World")
    variable
    condition
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
    println("i:"+i+" s:"+s+" str:"+str)
  }
}
